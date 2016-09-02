package life.grass.grasscore.player.event;

import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventGC implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        PlayerManagerGC.instance.registerPlayer(event.getPlayer());
    }
}
