package life.grass.grasscore;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import life.grass.grasscore.entity.EntityDeathEventGC;
import life.grass.grasscore.item.GrassItem;
import life.grass.grasscore.item.ItemPacketRewriter;
import life.grass.grasscore.item.tags.Armor;
import life.grass.grasscore.item.tags.ItemTag;
import life.grass.grasscore.item.types.ArmorType;
import life.grass.grasscore.knowledge.EBaseKnowledge;
import life.grass.grasscore.knowledge.KnowledgeManager;
import life.grass.grasscore.mining.event.MiningEventGC;
import life.grass.grasscore.player.event.PlayerFishingEventGC;
import life.grass.grasscore.player.event.PlayerLoginEventGC;
import life.grass.grasscore.player.event.PlayerQuitEventGC;
import life.grass.grasscore.timer.DataSaveTimer;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class GrassCore extends JavaPlugin implements CommandExecutor {
    public static Logger log;
    public static PluginManager pluginManager;
    private ProtocolManager protocolManager;
    private BukkitTask dataSaveTask = null;
    public static GrassCore instance;

    public static GrassCore getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance  = this;
        getServer().getPluginManager().registerEvents(new PlayerLoginEventGC(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEventGC(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishingEventGC(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathEventGC(), this);
        getServer().getPluginManager().registerEvents(new MiningEventGC(), this);
        protocolManager = ProtocolLibrary.getProtocolManager();
        ItemPacketRewriter.getInstance().addListener(protocolManager, this);
        dataSaveTask = this.getServer().getScheduler().runTaskTimer(this, new DataSaveTimer(this), 0L, 20L*60*10);
        if(KnowledgeManager.instance.getKnowledgeList().isEmpty()) {
            Stream.of(EBaseKnowledge.values()).forEach(b -> KnowledgeManager.instance.registerKnowledge(b.name(), b.getLabel(), b.getRate()));
        }
        log = getLogger();
    }

    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelTask(dataSaveTask.getTaskId());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equals("grasscore")) {
            GrassItem item = new GrassItem(new ItemStack(Material.IRON_SWORD));
            item.setId(1);
            item.setRarity(1);
            String[] info = {"line1", "line2"};
            item.setInfo(info);
            ArrayList<ItemTag> tags = new ArrayList<>();
            Armor armor = new Armor();
            armor.setDefense(1);
            armor.setProtection(10);
            armor.setType(ArmorType.ARMOR);
            tags.add(armor);
            item.setTags(tags);
            Player player = (Player) sender;
            log.info("GrassItem -> ItemStack");
            log.info(item.toItemStack().toString());
            player.getInventory().setItemInMainHand(item.toItemStack());
            log.info("ItemStack -> GrassItem");
            GrassItem item2 = new GrassItem(item.toItemStack());
            log.info("id " + item2.getId() + "");
            log.info("rarity " + item2.getRarity() + "");
            log.info(item2.getInfo().toString());
            log.info(item2.readTag(Armor.class) + "");
            Armor a = (Armor) item2.readTag(Armor.class);
            log.info(a.getDefense() + " " + a.getProtection() + " " +a.getType());
        }
        return true;
    }
}