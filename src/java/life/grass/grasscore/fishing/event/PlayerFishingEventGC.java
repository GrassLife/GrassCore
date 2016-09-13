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
        event.setExpToDrop(0);

        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Item gottenFish = (Item) event.getCaught();
            double rNumber1 = Math.random();
            //ここで乱数をナレッジなどに基づいて増加させる予定

            if (rNumber1 < 0.1) {
                gottenFish.remove();
                /*はずれ*/
            } else {
                FishingManager fishingManager = new FishingManager();
                List<Double> rsumList = fishingManager.getRsumList();
                double rNumber2 = Math.random() * rsumList.get(rsumList.size() - 1);

                if (rNumber2 < rsumList.get(0)) {
                    System.out.println("You gotta" + fishingManager.getFitemList().get(0));
                    gottenFish.setItemStack(new ItemStack(Material.RAW_CHICKEN));
                    //一番初めの要素はfor文で表せない(０以上のパターン)のでこう書いた。
                } else {

                    for (int i = 1; i < rsumList.size(); i++) {

                        if (rNumber2 > rsumList.get(i - 1) && rNumber2 < rsumList.get(i)) {
                            System.out.println("You gotta" + fishingManager.getFitemList().get(i));
                            gottenFish.setItemStack(new ItemStack(Material.RAW_BEEF));
                            //本来はリストに基づいて釣れるものが決まるがテストの段階ではめんどくさいのでこうしとく。
                        }
                    }
                }

            }

        }

    }
}
