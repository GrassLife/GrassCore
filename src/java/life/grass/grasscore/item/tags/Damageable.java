package life.grass.grasscore.item.tags;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Created by Ecila on 2016/09/03.
 */
public class Damageable implements ItemTag {
    private boolean hasGauge;
    private int current;
    private int max;

    public boolean isHasGauge() {
        return hasGauge;
    }

    public void setHasGauge(boolean hasGauge) {
        this.hasGauge = hasGauge;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
