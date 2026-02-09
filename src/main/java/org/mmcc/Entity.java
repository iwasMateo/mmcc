package org.mmcc;

import java.util.List;

public interface Entity {
    void damage(float currentHealth);
    float getHealth();
    float setHealth(float health);
    void addEffect(String effectid, int strength, int duration);
    void clearEffect(EffectType effect);
    List<FullEffect> getEffects();
    Vector3 getDimensions();
    String getEntityId();
}
