package life.grass.grasscore.knowledge;

public enum BaseKnowledge {
    AXE("戦斧", 1.0),
    BOOK_READING("読書", 1.0),
    BOOK_WRITING("執筆", 1.0),
    BOW("弓", 1.0),
    BREEDING("飼育", 1.0),
    CRAFTING("製作", 1.0),
    COOKING("料理", 1.0),
    DOWSING("ダウジング", 1.0),
    EATING("食事", 1.0),
    FARMING("農業", 1.0),
    FISHING("釣り", 1.0),
    HATCHET("手斧", 1.0),
    HEALTH("健康", 1.0),
    PICKAXE("ツルハシ", 1.0),
    RUNNING("走り", 1.0),
    SHOVEL("シャベル", 1.0),
    SWIMMING("水泳", 1.0),
    SWORD("剣", 1.0);

    private final String label;
    private final double rate;
    BaseKnowledge(String label, double rate){
        this.label = label;
        this.rate = rate;
    }
    public String getLabel(){
        return label;
    }
    public double getRate(){
        return rate;
    }
}
