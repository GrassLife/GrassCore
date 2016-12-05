package life.grass.grasscore.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Ecila on 2016/09/04.
 */
public class ItemManager {
    public static GrassItem getOriginGrassItem(int id) {
        return new GrassItem(new ItemStack(Material.AIR));
    }

    public static GrassItem getOriginGrassItem(ItemStack item) {
        return new GrassItem(item);
    }
}
