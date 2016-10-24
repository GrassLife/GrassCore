package life.grass.grasscore.mining;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static java.lang.Math.abs;
import static java.lang.Math.exp;
import static java.lang.Math.pow;

/**
 * Created by takah on 2016/10/23.
 */
public enum EMinableItems {

    COAL(new ItemStack(Material.COAL), 60, 0.022, 2.8),
    IRON_ORE(new ItemStack(Material.IRON_ORE), 40, 0.0175, 2),
    GOLD_ORE(new ItemStack(Material.GOLD_ORE), 30, 0.0075, 2),
    LAPIS_LAZULI(new ItemStack(Material.INK_SACK, 1, (short)4), 35, 0.012, 0.5),
    EMERALD(new ItemStack(Material.EMERALD), 20, 0.015, 0.2),
    DIAMOND(new ItemStack(Material.DIAMOND), 13, 0.002, 1.5),
    REDSTONE(new ItemStack(Material.REDSTONE), 15, 0.02, 1.4);

    private final ItemStack material;
    private final int modeHeight;
    private final double highestRatio;
    private final double vRate;

    EMinableItems(ItemStack material, int modeHeight, double highestRatio, double vRate) {
        this.material = material;
        this.modeHeight = modeHeight;
        this.highestRatio = highestRatio;
        this.vRate = vRate;
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
        double ratio = (exp( -pow((modeHeight - bLocation.getY()) * 2 / modeHeight * vRate, 2))) * highestRatio;
        if (prob < ratio && prob > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, material);
        }
    }


}
