package life.grass.grasscore;

import life.grass.grasscore.knowledge.BaseKnowledge;
import life.grass.grasscore.knowledge.KnowledgeManager;
import life.grass.grasscore.player.event.PlayerLoginEventGC;
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
        Stream.of(BaseKnowledge.values()).forEach(b -> KnowledgeManager.instance.registerKnowledge(b.name(), b.getLabel(), b.getRate()));
    }

    @Override
    public void onDisable() {

    }
}