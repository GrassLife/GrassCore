package life.grass.grasscore;

import life.grass.grasscore.entity.EntityDeathEventGC;
import life.grass.grasscore.knowledge.EBaseKnowledge;
import life.grass.grasscore.knowledge.KnowledgeManager;
import life.grass.grasscore.player.event.PlayerFishingEventGC;
import life.grass.grasscore.player.event.PlayerLoginEventGC;
import life.grass.grasscore.player.event.PlayerQuitEventGC;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import java.util.stream.Stream;

public class Grasscore extends JavaPlugin {
    public static Logger log;
    public static PluginManager pluginManager;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerLoginEventGC(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEventGC(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishingEventGC(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathEventGC(), this);
        if(KnowledgeManager.instance.getKnowledgeList().isEmpty()) {
            Stream.of(EBaseKnowledge.values()).forEach(b -> KnowledgeManager.instance.registerKnowledge(b.name(), b.getLabel(), b.getRate()));
        }
    }

    @Override
    public void onDisable() {

    }
}