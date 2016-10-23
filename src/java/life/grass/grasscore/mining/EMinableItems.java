package life.grass.grasscore.mining;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static java.lang.Math.abs;

/**
 * Created by takah on 2016/10/23.
 */
public enum EMinableItems {

    COAL(new ItemStack(Material.COAL), 60, 0.025),
    IRON_ORE(new ItemStack(Material.IRON_ORE), 40, 0.0175),
    GOLD_ORE(new ItemStack(Material.GOLD_ORE), 30, 0.0075),
    LAPIS_LAZULI(new ItemStack(Material.INK_SACK, 1, (short)4), 35, 0.01),
    EMERALD(new ItemStack(Material.EMERALD), 20, 0.0075),
    DIAMOND(new ItemStack(Material.DIAMOND), 13, 0.002),
    REDSTONE(new ItemStack(Material.REDSTONE), 15, 0.02);

    private final ItemStack material;
    private final int modeHeight;
    private final double highestRatio;

    EMinableItems(ItemStack material, int modeHeight, double highestRatio) {
        this.material = material;
        this.modeHeight = modeHeight;
        this.highestRatio = highestRatio;
    }

    public ItemStack getMaterial() {
        return material;
    }

    public int getModeHeight() {
        return modeHeight;
    }

    public double getHighestRatio() {
        return highestRatio;
    }

    public void dropItem(BlockBreakEvent event, Location bLocation){
        double prob = Math.random();
        double ratio = (1 - abs(modeHeight- bLocation.getY()) / modeHeight) * highestRatio;
        if (prob < ratio && prob > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, material);
        }
    }


}
