package life.grass.grasscore.mining.event;

import life.grass.grasscore.GrassCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * Created by takah on 2016/10/04.
 */
public class MiningEventGC implements Listener{
    @EventHandler
    public void onMining(BlockBreakEvent event){
        Location bLocation = event.getBlock().getLocation();
        if(event.getBlock().getType() == Material.STONE) {
            BukkitScheduler scheduler = GrassCore.getInstance().getServer().getScheduler();
            scheduler.scheduleSyncDelayedTask(GrassCore.getInstance(), new Runnable() {
                @Override
                public void run() {
                    event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.COAL));
                }
            }, 5L);

        }
    }
}