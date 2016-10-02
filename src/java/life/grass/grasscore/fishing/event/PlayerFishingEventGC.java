package life.grass.grasscore.fishing.event;

import life.grass.grasscore.fishing.FishableItem;
import life.grass.grasscore.fishing.FishingManager;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.block.Biome;
import org.bukkit.entity.Item;
import org.bukkit.entity.Weather;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyclicester on 2016/09/03.
 */
public class PlayerFishingEventGC implements Listener {
    @EventHandler
    public void onPlayerFishing(PlayerFishEvent event) {
        Biome playerBiome = event.getPlayer().getLocation().getWorld()
                .getBiome(event.getPlayer().getLocation().getBlockX(), event.getPlayer().getLocation().getBlockZ());
        WeatherType playerWeather = event.getPlayer().getPlayerWeather();
        event.setExpToDrop(0);

        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            Item gottenFish = (Item) event.getCaught();
            List<Double> nope = FishingManager.makeSumList(FishingManager.makeFailList());
            if(FishingManager.probMaker(nope) == 0){
                gottenFish.remove();
            } else {
                List<Double> ratioList = FishingManager.makeRatioList(playerBiome, playerWeather);
                List<Double> rsumList = FishingManager.makeSumList(ratioList);
                FishableItem harvest = FishingManager.getFishList().get(FishingManager.probMaker(rsumList));
                        System.out.println("You gotta" + harvest);
                        gottenFish.setItemStack(FishingManager.getFitemMap().get(harvest));
                    }
                }

    }

}
