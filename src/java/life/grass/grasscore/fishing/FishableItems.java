package life.grass.grasscore.fishing;

import org.bukkit.block.Biome;
import org.bukkit.entity.Weather;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by takah on 2016/09/08.
 */
public class FishableItems {
    private int defaultRatio;
    private HashMap<Biome, Double> bioRate = new HashMap<>();
    private HashMap<Weather, Double> weatherRate = new HashMap<>();

    FishableItems(int r){
        this.defaultRatio = r;
    }

    public double getRealatio(Biome b, Weather w){
        double realRatio;
        double r1;
        double r2;

        if(bioRate.get(b) == null){
            r1 = 1;
        }else{
            r1 = bioRate.get(b);
        }
        if(weatherRate.get(w) == null){
            r2 = 1;
        }else{
            r2 = weatherRate.get(w);
        }
        realRatio = r1 * r2 * defaultRatio;
        return realRatio;
    }
}
