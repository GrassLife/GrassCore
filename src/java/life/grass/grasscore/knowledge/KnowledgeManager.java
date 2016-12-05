package life.grass.grasscore.knowledge;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeManager {
    private List<BaseKnowledge> knowledgeList = new ArrayList<>();

    public static KnowledgeManager instance = new KnowledgeManager();
    public KnowledgeManager() {}

    public void registerKnowledge(String name, String label, double rate) {
        List<BaseKnowledge> tmp = new ArrayList<>();
        tmp.add(new BaseKnowledge(name, label, rate));
        knowledgeList.add(new BaseKnowledge(name, label, rate));
    }

    public BaseKnowledge getKnowledge(String knowledgeName){
        return knowledgeList.stream().filter(k -> k.getName().equals(knowledgeName)).findFirst().orElse(null);
    }
    public BaseKnowledge getKnowledge(EBaseKnowledge knowledge){
        return knowledgeList.stream().filter(k -> k.getName().equals(knowledge.name())).findFirst().orElse(null);
    }

    public List<BaseKnowledge> getKnowledgeList() {
        return this.knowledgeList;
    }
}
