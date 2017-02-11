package life.grass.grasscore.housing.event;

import life.grass.grasscore.housing.House;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * Created by takah on 2016/12/11.
 */
public class HousingEvent implements Listener {
    @EventHandler
    public void onHousing(BlockPlaceEvent event){
        if (event.getBlockPlaced().getType() == Material.COAL_ORE){
            House house = new House(event.getPlayer().getName(), event.getBlock().getLocation());
            System.out.println(house.getCentralLocation() + house.getPlayerName());
            event.getPlayer().sendMessage("This block is set as center of your house!! Welcome home!! Owner: " + event.getPlayer().getName());
        }
    }

}
