package life.grass.grasscore.timer;

import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.plugin.java.JavaPlugin;

public class LifespanCheckTimer implements Runnable {
    JavaPlugin plugin;
    public LifespanCheckTimer(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        PlayerManagerGC.instance.getPlayerInfoList().forEach(p -> {
            p.shrinkLifespan();
            if(p.getLifespan() <= 0){
                //寿命尽きたときの処理
            }
        });
    }
}
