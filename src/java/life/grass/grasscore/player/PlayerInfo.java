package life.grass.grasscore.player;

import life.grass.grasscore.knowledge.Knowledge;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerInfo {
    public Player player;
    public UUID uuid;

    public KnowledgeStats knowledgeStats;

    public PlayerInfo(Player player, UUID uuid){
        this.player = player;
        this.uuid = uuid;
        knowledgeStats = new KnowledgeStats(player);
    }

    public KnowledgeRank getKnowledgeRank(Knowledge knowledge){
        return new KnowledgeRank(knowledgeStats.getKnowledgePointMap().get(knowledge));
    }

    private class KnowledgeRank{
        private int rankNum;
        private String rankName;

        public KnowledgeRank(int rankNum){
            this.rankNum = rankNum;
            if(rankNum == 0)
                rankName = "NOVICE";
            else if(1 <= rankNum && rankNum <= 3)
                rankName = "BEGINNER " + String.valueOf(rankNum);
            else if(4 <= rankNum && rankNum <= 8)
                rankName = "VETERAN " + String.valueOf(rankNum - 3);
            else if(9 <= rankNum && rankNum <= 18)
                rankName = "MASTER " + String.valueOf(rankNum - 8);
            else if(rankNum == 19)
                rankName = "DOCTOR";
            else
                rankName = null;
        }

    }
}
