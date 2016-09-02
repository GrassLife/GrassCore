package life.grass.grasscore.player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManagerGC {
    private List<PlayerInfo> playerInfoList = new ArrayList<>();

    public static PlayerManagerGC instance = new PlayerManagerGC();
    public PlayerManagerGC() {}

    public void registerPlayer(Player player){
        playerInfoList.add(new PlayerInfo(player));
    }
    public void unregisterPlayer(Player player){
        playerInfoList.remove(getPlayerInfo(player));
    }

    public List<PlayerInfo> getPlayerInfoList(){
        return playerInfoList;
    }

    public PlayerInfo getPlayerInfo(Player player){
        return playerInfoList.stream().filter(pi -> pi.getPlayer().equals(player)).findFirst().orElse(null);
    }
}
