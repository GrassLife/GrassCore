package life.grass.grasscore.item.tags;

import life.grass.grasscore.item.types.EfficacyType;

import java.util.HashMap;

/**
 * Created by Ecila on 2016/09/04.
 */
public class CraftMaterial implements ItemTag {
    private HashMap<EfficacyType, Integer> efficasy = new HashMap<>();

    public HashMap<EfficacyType, Integer> getEfficasy() {
        return efficasy;
    }

    public void setEfficasy(HashMap<EfficacyType, Integer> efficasy) {
        this.efficasy = efficasy;
    }

    @Override
    public String toJson() {
        return null;
    }
}
