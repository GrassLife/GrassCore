package life.grass.grasscore.timer;

import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSaveTimer implements Runnable {
    JavaPlugin plugin;//BukkitのAPIにアクセスするためのJavaPlugin
    public DataSaveTimer(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        PlayerManagerGC.instance.getPlayerInfoList().forEach(p -> {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "gennpaku7");
                Statement statement = connection.createStatement();
                String knowledgePointSQL = "update knowledge set " + p.getKnowledgeStats().getKnowledgePointString();
                String theoryPointSQL = "update theory set " + p.getKnowledgeStats().getTheoryPointString();
                String lifespanSQL = "update lifespan set \'lifespan\'=" + p.getLifespan();
                String tmp = " where uuid=\'" + p.getUUID().toString() + "\'";
                knowledgePointSQL += tmp;
                theoryPointSQL += tmp;
                lifespanSQL += tmp;
                statement.executeUpdate(knowledgePointSQL);
                statement.executeUpdate(theoryPointSQL);
                statement.executeUpdate(lifespanSQL);
            } catch (SQLException e){
                e.printStackTrace();
                p.getPlayer().kickPlayer("データベース保存でエラーが発生しました。管理者に問い合わせてください");
            }
        });
    }
}
