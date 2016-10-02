package life.grass.grasscore.item.tags;

import life.grass.grasscore.item.types.ToolType;

/**
 * Created by Ecila on 2016/09/04.
 */
public class Tool implements ItemTag {
    private int power;
    private ToolType type;

    @Override
    public String toJson() {
        return null;
    }
}
