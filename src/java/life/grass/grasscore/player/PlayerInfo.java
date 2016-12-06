package life.grass.grasscore.player;

import life.grass.grasscore.knowledge.BaseKnowledge;
import life.grass.grasscore.knowledge.EBaseKnowledge;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

public class PlayerInfo {
    private Player player;
    private UUID uuid;
    private int lifespan;
    private int healthLevel; //range: 1 to 100

    private KnowledgeStats knowledgeStats;

    public PlayerInfo(Player player){
        this.player = player;
        this.uuid = player.getUniqueId();
        knowledgeStats = new KnowledgeStats(player);
    }

    public KnowledgeRank getKnowledgeRank(BaseKnowledge knowledge){
        return new KnowledgeRank((knowledgeStats.getKnowledgePointMap().get(knowledge)+9999)/10000);
    }

    public Player getPlayer(){
        return player;
    }

    public UUID getUUID(){
        return uuid;
    }

    public KnowledgeStats getKnowledgeStats(){
        return knowledgeStats;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan){
        this.lifespan = lifespan;
    }

    public void resetLifespan() {
        setLifespan(20000);
    }

    public void shortenLifespan(int value){
        lifespan -= value;
    }

    public void shrinkLifespan() {
        lifespan -= (101 - healthLevel);
    }

    public void penaltyKnowledgeStats(){
        Stream.of(EBaseKnowledge.values()).forEach(b -> {
            if(true) {  //もし子となるアドバンスド知識がプロフェッショナルでなければ
                knowledgeStats.demotionKnowledge(b.name());
            }
            knowledgeStats.setTheoryPoint(b.name(), 0);
        });
    }

    public class KnowledgeRank{
        public int rankNum;
        public String rankName;

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
