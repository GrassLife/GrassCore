package life.grass.grasscore.item.enchant;

/**
 * Created by ecila on 2016/12/05.
 */
public enum EnchantPosition {
    SPECIAL(0),
    PREFIX(1),
    SUFFIX(2);

    private final int positionId;

    EnchantPosition(int i) {
        positionId = i;
    }

    public int getId() {
        return positionId;
    }
}
