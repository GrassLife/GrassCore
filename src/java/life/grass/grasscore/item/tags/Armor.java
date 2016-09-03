package life.grass.grasscore.item.tags;

import com.google.gson.JsonObject;
import life.grass.grasscore.item.type.ArmorType;

/**
 * Created by Ecila on 2016/09/03.
 */
public class Armor implements ItemTag {
    int defense;
    int protection;
    ArmorType type;

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
        JsonObject json = new JsonObject();
        json.addProperty("defense", this.getDefense());
        json.addProperty("protection", this.getProtection());
        json.addProperty("type", this.getType().toString());
        return json.toString();
    }
}
