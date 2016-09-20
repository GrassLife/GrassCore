package life.grass.grasscore.item;

import com.google.gson.*;
import life.grass.grasscore.Grasscore;
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
        String className = "life.grass.grasscore.item.tags" + prim.getAsString();
        Class<?> klass;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JsonParseException(e.getMessage());
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
