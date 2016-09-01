package life.grass.grasscore.knowledge;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeManager {
    private List<Knowledge> knowledgeList = new ArrayList<>();

    public static KnowledgeManager instance = new KnowledgeManager();

    public KnowledgeManager() {}

    public void registerKnowledge(String name, double rate) {
        knowledgeList.add(new Knowledge(name, rate));
    }

    public List<Knowledge> getKnowledgeList() {
        return this.knowledgeList;
    }
}
