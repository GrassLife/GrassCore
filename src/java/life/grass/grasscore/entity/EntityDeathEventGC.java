package life.grass.grasscore.entity;

import life.grass.grasscore.item.GrassItem;
import life.grass.grasscore.item.tags.ItemTag;
import life.grass.grasscore.item.tags.Weapon;
import life.grass.grasscore.item.types.WeaponType;
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
            GrassItem grassItem = new GrassItem(playerInfo.getPlayer().getInventory().getItemInMainHand());
            ItemTag itemTag = grassItem.readTag(Weapon.class);
            if(itemTag instanceof Weapon){
                if(((Weapon)itemTag).getType() == WeaponType.SWORD){
                    playerInfo.getKnowledgeStats().increaseKnowledgePoint("SWORD", 1);
                    System.out.println(playerInfo.getKnowledgeStats().getKnowledgePoint("SWORD"));
                } else if(((Weapon)itemTag).getType() == WeaponType.BATTLE_AXE) {
                    playerInfo.getKnowledgeStats().increaseKnowledgePoint("AXE", 1);
                    System.out.println(playerInfo.getKnowledgeStats().getKnowledgePoint("AXE"));
                }
            }
        }
    }
}