package life.grass.grasscore.knowledge;

public class Knowledge {
    private String label;
    private String name;
    private double rate;

    public Knowledge(String name, String label ,double rate){
        this.label = label;
        this.name = name;
        this.rate = rate;
    }

    public String getName(){
        return name;
    }
    public  String getLabel(){
        return label;
    }
    public double getRate(){
        return rate;
    }
}
