package life.grass.grasscore.item;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import life.grass.grasscore.item.tags.ItemTag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ecila on 2016/09/02.
 */
public class GrassItem extends ItemStack {
    private int id;
    private String[] info;
    private int rarity;
    private ArrayList<ItemTag> tags = new ArrayList<>();

    /**
     * ItemStackからGrassItemを生成します。ItemStackのLoreにあるJson情報を解析します。
     * @param item
     */
    public GrassItem(ItemStack item) {
        super(item);

        ItemMeta meta = item.getItemMeta();
        if(meta.hasLore()) {
            //バニラアイテムの処理
        }
        List<String> lore = meta.getLore();
        this.setId(Integer.getInteger(lore.get(0)));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public ItemStack toItemStack() {
        Gson gson = new Gson();
        ItemStack item = this;
        ItemMeta meta = item.getItemMeta();

        JsonObject json = new JsonObject();
        json.addProperty("rarity", this.rarity);
        json.addProperty("info", gson.toJson(getInfo()));

        List<String> lore = new ArrayList<>();
        lore.add(String.valueOf(this.id));
        lore.add(json.getAsString());
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
