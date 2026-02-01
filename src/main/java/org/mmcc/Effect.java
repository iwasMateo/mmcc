package org.mmcc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Effect {
    private static EffectType getEffect(String id) {
        try {
            Field field = Item.class.getDeclaredField(id);
            if(!Modifier.isStatic(field.getModifiers())) return null;
            if (!ItemRecord.class.isAssignableFrom(field.getType())) return null;
            return (EffectType) field.get(null); // static → null
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }
    public static final EffectType poison = new EffectType(
            "poison",
            "Poison"
    );
    public static final EffectType regeneration = new EffectType(
            "regeneration",
            "Regeneration"
    );
}
