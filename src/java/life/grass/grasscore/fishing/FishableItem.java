package life.grass.grasscore.fishing;

import org.bukkit.WeatherType;
import org.bukkit.block.Biome;
import org.bukkit.entity.Weather;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

/**
 * Created by takah on 2016/09/08.
 */
public class FishableItem {
    private int defaultRatio;
    private HashMap<Biome, Double> bioRate = new HashMap<>();
    private HashMap<WeatherType, Double> weatherRate = new HashMap<>();
    private double realRatio;

    FishableItem(int value){
        this.defaultRatio = value;
    }

    public double getRealratio(Biome b, WeatherType w) {
        double r1;
        double r2;

        r1 = bioRate.get(b) == null ? 1 : bioRate.get(b);

        r2 = weatherRate.get(w) == null ? 1 : weatherRate.get(w);

        realRatio = r1 * r2 * defaultRatio;
        return realRatio;
    }

    public void setBioRate(HashMap<Biome, Double> bioRate) {
        this.bioRate = bioRate;
    }

    public void setWeatherRate(HashMap<WeatherType, Double> weatherRate) {
        this.weatherRate = weatherRate;
    }


}
