package life.grass.grasscore.mining.event;

import life.grass.grasscore.GrassCore;
import life.grass.grasscore.mining.MiningManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
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
                    MiningManager.decideDrop(event, bLocation);
                }
            }, 5L);

        }
    }
}