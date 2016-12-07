package life.grass.grasscore.timer;

import life.grass.grasscore.GrassCore;
import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.plugin.java.JavaPlugin;

public class ClockTimer implements Runnable {
    JavaPlugin plugin;
    public ClockTimer(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        GrassCore.getInstance().timeFlow.proceedTime();
    }
}
