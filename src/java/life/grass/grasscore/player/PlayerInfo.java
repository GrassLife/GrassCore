package life.grass.grasscore.player;

import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerInfo {
    public String playerName;
    public UUID playerUUID;

    public KnowledgeStats knowledgeStats;

    public PlayerInfo(String playerName, UUID playerUUID){
        this.playerName = playerName;
        this.playerUUID = playerUUID;
    }
}
