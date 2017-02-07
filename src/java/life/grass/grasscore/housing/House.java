package life.grass.grasscore.housing;

import org.bukkit.Location;

/**
 * Created by takah on 2016/12/13.
 */
public class House {
    private String playerName;
    private Location centralLocation;

    public House(String name, Location location){
        this.playerName = name;
        this.centralLocation = location;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Location getCentralLocation() {
        return centralLocation;
    }
}