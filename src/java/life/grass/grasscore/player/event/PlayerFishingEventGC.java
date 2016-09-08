package life.grass.grasscore.player.event;

import life.grass.grasscore.knowledge.BaseKnowledge;
import life.grass.grasscore.knowledge.KnowledgeManager;
import life.grass.grasscore.player.PlayerInfo;
import life.grass.grasscore.player.PlayerManagerGC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishingEventGC implements Listener {
    @EventHandler
    public void onPlayerFishing(PlayerFishEvent event){
        if(event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)){
            BaseKnowledge knowledge = (BaseKnowledge)KnowledgeManager.instance.getKnowledge("FISHING");
            PlayerInfo playerInfo = PlayerManagerGC.instance.getPlayerInfo(event.getPlayer());
            playerInfo.getKnowledgeStats().increaseKnowledgePoint(knowledge.getName(), 1);
//            System.out.println("fishing = " + playerInfo.getKnowledgeStats().getKnowledgePointMap().get(knowledge).toString());
        }
    }
}
