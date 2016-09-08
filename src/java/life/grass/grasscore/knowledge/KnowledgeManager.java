package life.grass.grasscore.knowledge;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeManager {
    private List<AbstractKnowledge> knowledgeList = new ArrayList<>();

    public static KnowledgeManager instance = new KnowledgeManager();
    public KnowledgeManager() {}

    public void registerKnowledge(String name, String label, double rate) {
        List<BaseKnowledge> tmp = new ArrayList<>();
        tmp.add(new BaseKnowledge(name, label, rate));
        knowledgeList.add(new BaseKnowledge(name, label, rate));
    }

    public AbstractKnowledge getKnowledge(String knowledgeName){
        return knowledgeList.stream().filter(k -> k.getName().equals(knowledgeName)).findFirst().orElse(null);
    }

    public List<? super AbstractKnowledge> getKnowledgeList() {
        return this.knowledgeList;
    }
}
