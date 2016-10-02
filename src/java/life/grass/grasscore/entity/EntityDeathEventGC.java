package life.grass.grasscore.entity;

import life.grass.grasscore.knowledge.KnowledgeManager;
import life.grass.grasscore.player.PlayerInfo;
import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathEventGC implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        if(event.getEntity().getKiller() != null){
            PlayerInfo playerInfo = PlayerManagerGC.instance.getPlayerInfo(event.getEntity().getKiller());
            playerInfo.getKnowledgeStats().increaseKnowledgePoint("SWORD", 1);
            System.out.println(playerInfo.getKnowledgeStats().getKnowledgePoint("SWORD"));
        }
    }
}