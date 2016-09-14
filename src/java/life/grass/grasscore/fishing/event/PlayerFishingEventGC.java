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

import java.util.ArrayList;
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
            List<Double> nope = FishingManager.makeSumList(makeNope());//ここはratioListから取ってくる。
            if(FishingManager.probMaker(nope) == 0){
                gottenFish.remove();
            } else { new FishingManager();
                List<Double> rsumList = FishingManager.getRsumList();
                        System.out.println("You gotta" + FishingManager.getFitemList().get(FishingManager.probMaker(rsumList)));
                        gottenFish.setItemStack(new ItemStack(Material.RAW_BEEF));
                    }
                }

    }
    private List<Double> makeNope(){
        List<Double> list = new ArrayList<>();
        list.add(5.0);
        list.add(5.0);
        return list;//テスト用　後で消します
    }
}
