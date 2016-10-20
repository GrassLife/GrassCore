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
        /*
    石炭のドロップ
     */
        double prob1 = Math.random();
        double ratio1 = (1 - abs(60 - bLocation.getY()) / 60) * 0.025;
        if (prob1 < ratio1 && prob1 > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.COAL));
        }
        /*
        鉄のドロップ
         */
        double prob2 = Math.random();
        double ratio2 = (1 - abs(40 - bLocation.getY()) / 40) * 0.0175;
        if (prob2 < ratio2 && prob2 > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.IRON_ORE));
        }
        /*
        金のドロップ
         */
        double prob3 = Math.random();
        double ratio3 = (1 - abs(30 - bLocation.getY()) / 30) * 0.0075;
        if (prob3 < ratio3 && prob3 > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.GOLD_ORE));
        }
        /*
        ラピスのドロップ
         */
        double prob4 = Math.random();
        double ratio4 = (1 - abs(35 - bLocation.getY()) / 35) * 0.01;
        if (prob4 < ratio4 && prob4 > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.INK_SACK, 1, (short) 4));
        }
        /*
        エメラルドのドロップ
         */
        double prob5 = Math.random();
        double ratio5 = (1 - abs(20 - bLocation.getY()) / 20) * 0.0075;
        if (prob5 < ratio5 && prob5 > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.EMERALD));
        }
        /*
        ダイアモンドのドロップ
         */
        double prob6 = Math.random();
        double ratio6 = (1 - abs(13 - bLocation.getY()) / 13) * 0.002;
        if (prob6 < ratio6 && prob6 > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.DIAMOND));
        }
        /*
        レッドストーンのドロッぷ
         */
        double prob7 = Math.random();
        double ratio7 = (1 - abs(15 - bLocation.getY()) / 15) * 0.02;
        if (prob7 < ratio7 && prob7 > 0) {
            event.getPlayer().getWorld().dropItemNaturally(bLocation, new ItemStack(Material.REDSTONE));
        }
    }
}
