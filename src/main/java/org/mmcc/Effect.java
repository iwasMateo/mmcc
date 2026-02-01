package org.mmcc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Effect {
    public static EffectType getEffect(String id) {
        try {
            Field field = Item.class.getDeclaredField(id);
            if(!Modifier.isStatic(field.getModifiers())) return null;
            if (!ItemRecord.class.isAssignableFrom(field.getType())) return null;
            return (EffectType) field.get(null); // static → null
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }
    public void add(Entity entity, EffectType effect, int strength, int duration) {
        entity.addEffect(effect, strength, duration);
    }
    public void clear (Entity entity, EffectType effectType) {
        entity.clearEffect(effectType);
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
