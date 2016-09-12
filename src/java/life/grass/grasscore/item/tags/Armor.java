package life.grass.grasscore.item.tags;

import com.google.gson.Gson;
import life.grass.grasscore.item.types.ArmorType;

/**
 * Created by Ecila on 2016/09/03.
 */
public class Armor implements ItemTag {
    private int defense;
    private int protection;
    private ArmorType type;

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public ArmorType getType() {
        return type;
    }

    public void setType(ArmorType type) {
        this.type = type;
    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
