package life.grass.grasscore;

import life.grass.grasscore.fishing.event.PlayerFishingEventGC;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Grasscore extends JavaPlugin {
    public static Logger log;
    public static PluginManager pluginManager;

    @Override
    public void onEnable(){

        getServer().getPluginManager().registerEvents(new PlayerFishingEventGC(),this);
    }

    @Override
    public void onDisable(){

    }
}