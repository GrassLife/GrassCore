package life.grass.grasscore.mining;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static java.lang.Math.abs;

/**
 * Created by takah on 2016/10/04.
 */
public  class MiningManager {

    public static void decideDrop(BlockBreakEvent event, Location bLocation) {

        for (EMinableItems item : EMinableItems.values())
            item.dropItem(event, bLocation);

    }
}