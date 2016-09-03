package life.grass.grasscore.player.event;

import life.grass.grasscore.knowledge.KnowledgeManager;
import life.grass.grasscore.player.PlayerInfo;
import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.*;

public class PlayerQuitEventGC implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Connection connection = null;
        PlayerInfo playerInfo = PlayerManagerGC.instance.getPlayerInfo(event.getPlayer());
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "gennpaku7");
            Statement statement = connection.createStatement();
            String knowledgePointSQL = "update knowledge set " + playerInfo.getKnowledgeStats().getKnowledgePointString();
            String theoryPointSQL = "update theory set " + playerInfo.getKnowledgeStats().getTheoryPointString();
            String tmp = " where uuid=\'" + playerInfo.getUUID().toString() + "\'";
            knowledgePointSQL += tmp;
            theoryPointSQL += tmp;
            statement.executeUpdate(knowledgePointSQL);
            statement.executeUpdate(theoryPointSQL);
//            System.out.println("done");
        } catch (SQLException e){
            e.printStackTrace();
            event.getPlayer().kickPlayer("データベース保存でエラーが発生しました。管理者に問い合わせてください");
        }
        PlayerManagerGC.instance.unregisterPlayer(event.getPlayer());
    }
}
