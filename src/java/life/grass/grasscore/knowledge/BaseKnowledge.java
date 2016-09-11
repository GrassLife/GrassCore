package life.grass.grasscore.knowledge;


public class BaseKnowledge {
    private final String name;
    private final String label;
    private final double rate;

    public BaseKnowledge(String name, String label, double rate){
        this.name = name;
        this.label = label;
        this.rate = rate;
    }

    public String getName(){
        return name;
    }
    public String getLabel(){
        return label;
    }
    public double getRate(){
        return rate;
    }

    @Override
    public String toString(){
        return getName();
    }
}
