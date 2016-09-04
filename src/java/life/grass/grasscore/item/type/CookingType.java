package life.grass.grasscore.item.type;

/**
 * Created by Ecila on 2016/09/03.
 */
public enum CookingType {
    MIX("混ぜる"),
    GRILL("焼く"),
    BOIL("茹でる"),
    SIMMER("煮る"),
    SAUTE("炒める"),
    DEEP_FRY("揚げる");

    private final String label;

    CookingType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
