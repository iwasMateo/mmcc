package org.mmcc;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Item {
    public static boolean hasFinal(Class<?> clazz, String name) {
        try {
            Field field = clazz.getDeclaredField(name);
            return Modifier.isFinal(field.getModifiers());
        } catch (NoSuchFieldException e) {
            return false; // no field with name
        }
    }
    public static ItemRecord getItem(String id) {
        try {
            Field field = Item.class.getDeclaredField(id);
            if(!Modifier.isStatic(field.getModifiers())) return null;
            if (!ItemRecord.class.isAssignableFrom(field.getType())) return null;
            return (ItemRecord) field.get(null); // static → null
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }
    public static final ItemRecord empty = new ItemRecord(
            "empty",
            "",
            0,
            false,
            0
    );
    public static final ItemRecord apple = new ItemRecord(
            "apple",
            "Apple",
            64,
            true,
            20
    );
    public static final ItemRecord sword = new ItemRecord(
            "sword",
            "Sword",
            64,
            true,
            20
    );
}


