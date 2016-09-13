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
    private int defaultratio;
    private HashMap<Biome, Double> biorate = new HashMap<>();
    private HashMap<Weather, Double> weatherrate = new HashMap<>();

    FishableItems(int r){
        this.defaultratio = r;
    }

    public double getRealratio(Biome b, Weather w){
        double realratio;
        double r1;
        double r2;

        if(biorate.get(b) == null){
            r1 = 1;
        }else{
            r1 = biorate.get(b);
        }
        if(weatherrate.get(w) == null){
            r2 = 1;
        }else{
            r2 = weatherrate.get(b);
        }
        realratio = r1 * r2 * defaultratio;
        return realratio;
    }
}
