package life.grass.grasscore.fishing.event;

import life.grass.grasscore.fishing.FishingManager;
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

import java.util.List;

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
            if (rnumber1 < 0.1) {
                gottenfish.remove();
                /*はずれ*/
            } else {
                FishingManager fishingmanager = new FishingManager();
                List<Double> rsumlist = fishingmanager.getRsumlist();
                double rnumber2 = Math.random() * rsumlist.get(rsumlist.size() - 1);
                if (rnumber2 < rsumlist.get(0)) {
                    System.out.println("You gotta" + fishingmanager.getFitemlist().get(0));
                    gottenfish.setItemStack(new ItemStack(Material.RAW_CHICKEN));
                    //一番初めの要素はfor文で表せない(０以上のパターン)のでこう書いた。
                } else {
                    for (int i = 1; i < rsumlist.size(); i++) {
                        if (rnumber2 > rsumlist.get(i - 1) && rnumber2 < rsumlist.get(i)) {
                            System.out.println("You gotta" + fishingmanager.getFitemlist().get(i));
                            gottenfish.setItemStack(new ItemStack(Material.RAW_BEEF));
                            //本来はリストに基づいて釣れるものが決まるがテストの段階ではめんどくさいのでこうしとく。
                        }
                    }
                }

            }

        }

    }
}
