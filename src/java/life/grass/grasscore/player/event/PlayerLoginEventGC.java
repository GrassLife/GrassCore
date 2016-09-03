package life.grass.grasscore.player.event;

import life.grass.grasscore.knowledge.KnowledgeManager;
import life.grass.grasscore.player.PlayerInfo;
import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.sql.*;

public class PlayerLoginEventGC implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event){
        Connection connection = null;
        PlayerManagerGC.instance.registerPlayer(event.getPlayer());
        PlayerInfo playerInfo = PlayerManagerGC.instance.getPlayerInfo(event.getPlayer());
//        System.out.println("\'" + playerInfo.getUUID().toString() + "\'");
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "gennpaku7");
            Statement statement = connection.createStatement();
            String sql = "select * from knowledge where uuid=\'" + playerInfo.getUUID().toString() + "\'";
            System.out.println(sql);
            ResultSet knowledgeResultSet = statement.executeQuery(sql);
            if(!(knowledgeResultSet.next())){
                String knowledgeSQL = "insert into knowledge(uuid) value(\'" + playerInfo.getUUID().toString() + "\')";
                String theorySQL = "insert into theory(uuid) value(\'" + playerInfo.getUUID().toString() + "\')";
                statement.executeUpdate(knowledgeSQL);
                statement.executeUpdate(theorySQL);
                knowledgeResultSet.close();
            } else{
                sql = "select * from knowledge where uuid=\'" + playerInfo.getUUID().toString() + "\'";
                ResultSet theoryResultSet = statement.executeQuery(sql);
                theoryResultSet.next();
                KnowledgeManager.instance.getKnowledgeList().forEach(k -> {
                    try {
                        playerInfo.knowledgeStats.setKnowledgePoint(k, knowledgeResultSet.getInt(k.getName()));
                        playerInfo.knowledgeStats.setTheoryPoint(k, knowledgeResultSet.getInt(k.getName()));
                    } catch (SQLException e){
                        e.printStackTrace();
                        event.getPlayer().kickPlayer("データベース取得でエラーが発生しました。管理者に問い合わせてください");
                    }
                });
            }

        } catch (SQLException e){
            e.printStackTrace();
            event.getPlayer().kickPlayer("データベース取得でエラーが発生しました。管理者に問い合わせてください");
        }
    }
}
