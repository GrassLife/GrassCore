package life.grass.grasscore.timer;

import life.grass.grasscore.GrassCore;
import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.plugin.java.JavaPlugin;

public class LifespanCheckTimer implements Runnable {
    JavaPlugin plugin;
    public LifespanCheckTimer(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        PlayerManagerGC.getInstance().getPlayerInfoList().stream().forEach(p -> {
            p.shrinkLifespan();
            if(p.getLifespan() <= 0){
                //寿命が尽きたときの処理
            }
        });
    }
}
