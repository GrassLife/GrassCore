package life.grass.grasscore.knowledge;

abstract class AbstractKnowledge {
    abstract String getName();
    abstract String getLabel();
    abstract double getRate();

    @Override
    public String toString(){
        return getName();
    }
}
