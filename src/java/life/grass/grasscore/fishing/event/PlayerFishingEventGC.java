package life.grass.grasscore.fishing.event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by cyclicester on 2016/09/03.
 */
public class PlayerFishingEventGC implements Listener {
    @EventHandler
    public void onPlayerFishing(PlayerFishEvent event) {
        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Item gottenfish = (Item) event.getCaught();
            double rnumber1 = Math.random();
            //ここで乱数をナレッジなどに基づいて増加させる予定
            if(rnumber1 < 0.8) {
                gottenfish.remove();
                /*はずれ*/
            } else {
                gottenfish.setItemStack(new ItemStack(Material.RAW_FISH));
            }

        }

    }

}
