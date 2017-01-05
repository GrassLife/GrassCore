package life.grass.grasscore.item.enchant;

import com.google.gson.JsonObject;
import life.grass.grasscore.item.tags.ItemTag;

import java.util.ArrayList;

/**
 * Created by Ecila on 2016/09/03.
 */
public class Enchant {
    private int id;
    private String name;
    private String description;
    private EnchantPosition position;
    private ArrayList<ItemTag> tags;

    /**
     * JsonObjectからEnchantを生成します
     * @param json
     */
    public Enchant(JsonObject json) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String discription) {
        this.description = discription;
    }

    public ArrayList<ItemTag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<ItemTag> tags) {
        this.tags = tags;
    }

    public EnchantPosition getPosition() {
        return position;
    }

    public void setPosition(EnchantPosition position) {
        this.position = position;
    }

    public ItemTag readTag(Class tagClass) {
        for(ItemTag tag: getTags()) {
            if(tagClass.isAssignableFrom(tag.getClass())) {
                return tag;
            }
        }
        return null;
    }
}
