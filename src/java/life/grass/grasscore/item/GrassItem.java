package life.grass.grasscore.item;

import com.google.gson.*;
import life.grass.grasscore.Grasscore;
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
        if(!meta.hasLore()) {
            //バニラアイテムの処理
        } else {
            List<String> lore = meta.getLore();
            Gson gson = new Gson();
            Gson tagGson = new GsonBuilder().registerTypeAdapter(ItemTag.class, new ItemTagAdapter()).create();
            // 静的タグの読み込み
            this.setId(Integer.parseInt(lore.get(0)));
            JsonObject body = gson.fromJson(lore.get(1), JsonObject.class);
            this.setRarity(body.get("rarity").getAsInt());
            this.setInfo(gson.fromJson(body.get("info"), String[].class));
            // ItemTagの読み込み
            JsonArray tagContents = body.get("tags").getAsJsonArray();
            tagContents.forEach( tag -> tags.add(tagGson.fromJson(tag, ItemTag.class)));
        }
    }

    public ArrayList<ItemTag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<ItemTag> tags) {
        this.tags = tags;
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

    public ItemTag readTag(Class tagClass) {
        for(ItemTag tag: getTags()) {
            if(tagClass.isAssignableFrom(tag.getClass())) {
                return tag;
            }
        }
        return null;
    }

    public ItemStack toItemStack() {
        Gson gson = new Gson();
        Gson tagGson = new GsonBuilder().registerTypeAdapter(ItemTag.class, new ItemTagAdapter()).create();
        ItemStack item = this;
        ItemMeta meta = item.getItemMeta();

        JsonObject json = new JsonObject();
        // 静的タグの書き込み
        json.addProperty("rarity", this.rarity);
        json.add("info", gson.toJsonTree(getInfo()).getAsJsonArray());
        // ItemTagの書き込み
        JsonArray tagArray = new JsonArray();
        tags.forEach( tag -> tagArray.add(new JsonParser().parse(tagGson.toJson(tag, ItemTag.class))));
        json.add("tags", tagArray);

        List<String> lore = new ArrayList<>();
        lore.add(String.valueOf(this.id));
        lore.add(gson.toJson(json));
        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }
}
