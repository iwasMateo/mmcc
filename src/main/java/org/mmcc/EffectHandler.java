package org.mmcc;

import java.lang.reflect.Method;

public class EffectHandler {
    private void poison (Entity e, int strength, int duration) {
        float damage = 0.75f * strength;
        e.damage(damage);
        e.modEffect("poison", strength, duration-1);
    }
    public void applyEffects() throws Exception {
        for (Entity e : EntityManager.getInstance().getEntities()) {
            for (FullEffect i : e.getEffects()) {
                if (i.effect().id() != null) {
                    callByName(i.effect().id());
                }
            }
        }
    }
    public void callByName(String name) throws Exception {
        Method m = this.getClass().getDeclaredMethod(name);
        m.setAccessible(true); // needed for private methods
        m.invoke(this);
    }
}
