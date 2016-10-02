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
                String lifespanSQL = "insert into lifespan(uuid) value(\'" + playerInfo.getUUID().toString() + "\')";
                statement.executeUpdate(knowledgeSQL);
                statement.executeUpdate(theorySQL);
                statement.executeUpdate(lifespanSQL);
            } else{
                Statement statement2 = connection.createStatement();
                Statement statement3 = connection.createStatement();
                String theorySql = "select * from theory where uuid=\'" + playerInfo.getUUID().toString() + "\'";
                String lifespanSql = "select * from theory where uuid='" + playerInfo.getUUID().toString() + "\'";
                ResultSet theoryResultSet = statement2.executeQuery(theorySql);
                ResultSet lifespanResultSet = statement3.executeQuery(lifespanSql);
                theoryResultSet.next();
                lifespanResultSet.next();
                KnowledgeManager.instance.getKnowledgeList().forEach(k -> {
                    try {
//                        System.out.println(k.getName());
                        playerInfo.getKnowledgeStats().setKnowledgePoint(k.toString(), knowledgeResultSet.getInt(k.toString()));
//                        System.out.println(playerInfo.getKnowledgeStats().getKnowledgePoint(k));
                        playerInfo.getKnowledgeStats().setTheoryPoint(k.toString(), theoryResultSet.getInt(k.toString()));
                        playerInfo.setLifespan(lifespanResultSet.getInt("lifespan"));
                    } catch (SQLException e){
                        e.printStackTrace();
                        event.getPlayer().kickPlayer("データベース取得でエラーが発生しました。管理者に問い合わせてください");
                    }
                });
                theoryResultSet.close();
            }
            knowledgeResultSet.close();
        } catch (SQLException e){
            e.printStackTrace();
            event.getPlayer().kickPlayer("データベース取得でエラーが発生しました。管理者に問い合わせてください");
        }
    }
}
