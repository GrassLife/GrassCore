package life.grass.grasscore.item.enchant;

import life.grass.grasscore.item.tags.ItemTag;

import java.util.ArrayList;

/**
 * Created by Ecila on 2016/09/03.
 */
public class Enchant {
    private int id;
    private String label;
    private EnchantPosition position;
    private ArrayList<ItemTag> efficaciesList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public EnchantPosition getPosition() {
        return position;
    }

    public void setPosition(EnchantPosition position) {
        this.position = position;
    }

    public ArrayList<ItemTag> getEfficaciesList() {
        return efficaciesList;
    }

    public void setEfficaciesList(ArrayList<ItemTag> efficaciesList) {
        this.efficaciesList = efficaciesList;
    }
}
