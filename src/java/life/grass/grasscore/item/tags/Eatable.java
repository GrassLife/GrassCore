package life.grass.grasscore.item.tags;

import com.google.gson.Gson;

/**
 * Created by Ecila on 2016/09/03.
 */
public class Eatable implements ItemTag {
    private int restoreAmouont;
    private long expire;

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public int getRestoreAmouont() {
        return restoreAmouont;
    }

    public void setRestoreAmouont(int restoreAmouont) {
        this.restoreAmouont = restoreAmouont;
    }

    @Override
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
