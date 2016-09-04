package life.grass.grasscore.item.tags;

import com.google.gson.Gson;
import life.grass.grasscore.item.type.EfficacyType;

import java.util.HashMap;

/**
 * Created by Ecila on 2016/09/03.
 */
public class FoodMaterial implements ItemTag {
    private HashMap<EfficacyType, Integer> efficasy = new HashMap<>();
    private long expire;

    public HashMap<EfficacyType, Integer> getEfficasy() {
        return efficasy;
    }

    public void setEfficasy(HashMap<EfficacyType, Integer> efficasy) {
        this.efficasy = efficasy;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
