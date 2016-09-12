package life.grass.grasscore.item.tags;

import com.google.gson.Gson;
import life.grass.grasscore.item.types.ElementType;

/**
 * Created by Ecila on 2016/09/03.
 */
public class Elementable implements ItemTag {
    private int power;
    private ElementType type;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
