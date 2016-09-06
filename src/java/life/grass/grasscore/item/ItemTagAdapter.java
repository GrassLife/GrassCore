package life.grass.grasscore.item;

import com.google.gson.*;
import life.grass.grasscore.item.tags.*;

import java.lang.reflect.Type;

/**
 * Created by Ecila on 2016/09/06.
 */
public class ItemTagAdapter implements JsonSerializer<ItemTag>, JsonDeserializer<ItemTag> {
    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE = "INSTANCE";

    @Override
    public ItemTag deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();
        Class<?> klass;
        switch (className) {
            case "Armor":
                klass = Armor.class;
                break;
            case "CraftMaterial":
                klass = CraftMaterial.class;
                break;
            case "Damageable":
                klass = Damageable.class;
                break;
            case "Eatable":
                klass = Eatable.class;
                break;
            case "Elementable":
                klass = Elementable.class;
                break;
            case "FoodMaterial":
                klass = FoodMaterial.class;
                break;
            case "Tool":
                klass = Tool.class;
                break;
            case "Weapon":
                klass = Weapon.class;
                break;

            default:
                throw new JsonParseException("class not found. className=" + className);
        }

        return context.deserialize(jsonObject.get(INSTANCE), klass);
    }

    @Override
    public JsonElement serialize(ItemTag src, Type typeOfSrc, JsonSerializationContext context) throws JsonParseException {
        JsonObject retValue = new JsonObject();
        String className = src.getClass().getSimpleName();
        retValue.addProperty(CLASSNAME, className);
        JsonElement elem = context.serialize(src);
        retValue.add(INSTANCE, elem);
        return retValue;
    }
}
