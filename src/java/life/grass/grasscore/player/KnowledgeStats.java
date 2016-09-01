package life.grass.grasscore.player;

import life.grass.grasscore.knowledge.Knowledge;
import life.grass.grasscore.knowledge.KnowledgeManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class KnowledgeStats {
    private Map<Knowledge, Integer> knowledgePoint;
    private Map<Knowledge, Integer> theoryPoint;
    private Player player;

    public KnowledgeStats(Player player){
        this.player = player;
        knowledgePoint = new HashMap<>();
        theoryPoint = new HashMap<>();

        KnowledgeManager.instance.getKnowledgeList().forEach(k -> {
            knowledgePoint.put(k, 0);
            theoryPoint.put(k, 0);
        });
    }

    public Map<Knowledge, Integer> getKnowledgePointMap(){
        return knowledgePoint;
    }

    public Map<Knowledge, Integer> getTheoryPoint() {
        return theoryPoint;
    }

    private int getKnowledgePoint(Knowledge knowledge){
        return knowledgePoint.get(knowledge);
    }
    public void setKnowledgePoint(Knowledge knowledge, int value){
        knowledgePoint.put(knowledge, value);
    }
    private int getTheoryPoint(Knowledge knowledge){
        return theoryPoint.get(knowledge);
    }
    public void setTheoryPoint(Knowledge knowledge, int value){
        theoryPoint.put(knowledge, value);
    }

    public void increaseTheoryPoint(Knowledge knowledge, int value){

    }
}
