package life.grass.grasscore.knowledge;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeManager {
    private List<Knowledge> knowledgeList = new ArrayList<>();

    public static KnowledgeManager instance = new KnowledgeManager();
    public KnowledgeManager() {}

    public List<String> getKnowledgeNameList(){
        List<String> knowledgeNameList = new ArrayList<>();
        knowledgeList.forEach(k -> knowledgeNameList.add(k.getName()));
        return knowledgeNameList;
    }

    public void registerKnowledge(String name, String label, double rate) {
        knowledgeList.add(new Knowledge(name, label, rate));
    }

    public Knowledge getKnowledge(String knowledgeName){
        return knowledgeList.stream().filter(k -> k.getName().equals(knowledgeName)).findFirst().orElse(null);
    }

    public List<Knowledge> getKnowledgeList() {
        return this.knowledgeList;
    }
}
