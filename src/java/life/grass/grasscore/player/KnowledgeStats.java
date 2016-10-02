package life.grass.grasscore.player;

import life.grass.grasscore.knowledge.KnowledgeManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class KnowledgeStats {
    private Map<String , Integer> knowledgePoint;
    private Map<String , Integer> theoryPoint;
    private Player player;

    public KnowledgeStats(Player player){
        this.player = player;
        knowledgePoint = new HashMap<>();
        theoryPoint = new HashMap<>();

        KnowledgeManager.instance.getKnowledgeList().forEach(k -> {
            knowledgePoint.put(k.toString(), 0);
            theoryPoint.put(k.toString(), 0);
        });
    }

    public Map<String, Integer> getKnowledgePointMap(){
        return knowledgePoint;
    }

    public Map<String, Integer> getTheoryPoint() {
        return theoryPoint;
    }

    public int getKnowledgePoint(String knowledge){
        return knowledgePoint.get(knowledge);
    }
    public void setKnowledgePoint(String knowledge, int value){
        knowledgePoint.put(knowledge, value);
    }
    public int getTheoryPoint(String knowledge){
        return theoryPoint.get(knowledge);
    }
    public void setTheoryPoint(String knowledge, int value){
        theoryPoint.put(knowledge, value);
    }

    public String getKnowledgePointString(){
        String str = "";
        for(Map.Entry<String, Integer> k : knowledgePoint.entrySet()){
            str += ", " + k.getKey() + " = " + k.getValue().toString();
        }
        str = str.replaceFirst(", ", "");
        return str;
    }
    public String getTheoryPointString() {
        String str = "";
        for (Map.Entry<String, Integer> k : theoryPoint.entrySet()) {
            str += ", " + k.getKey() + " = " + k.getValue().toString();
        }
        str = str.replaceFirst(", ", "");
        return str;
    }
    public void increaseKnowledgePoint(String knowledge, int value){
        int currentKnowledgePoint = knowledgePoint.get(knowledge);
        if(currentKnowledgePoint > 180000)  return;
        int currentTheoryPoint = theoryPoint.get(knowledge);
        knowledgePoint.put(knowledge, currentKnowledgePoint+((int)(value/(KnowledgeManager.instance.getKnowledge(knowledge)).getRate()*(1+currentTheoryPoint/100.0))));
    }
    public void increaseTheoryPoint(String knowledge, int value){

    }
    public void demotionKnowledge(String knowledge){
        int currentKnowledgepoint = knowledgePoint.get(knowledge);
        if(currentKnowledgepoint > 90000){
            setKnowledgePoint(knowledge, 80001);
        } else if(currentKnowledgepoint > 40000){
            setKnowledgePoint(knowledge, 30001);
        } else if(currentKnowledgepoint > 10000){
            setKnowledgePoint(knowledge, 1);
        } else{
            setKnowledgePoint(knowledge, 0);
        }
    }
}
