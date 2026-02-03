package org.mmcc;
import java.util.ArrayList;
import java.util.List;

public class PlayerStatus implements Entity{
    public float maxHealth = 20;
    public float currentHealth;
    public Vector3 dirSpeed;
    public float hunger;
    public Vector3 viewDir;
    public int experience;
    public List<EffectBehavior> effects;
    public Vector3 size = new Vector3(0.8f, 1.8f, 0.8f);
    public String id = "player";

    public void init () {
        currentHealth = maxHealth;
        dirSpeed = new Vector3(0, 0, 0);
        hunger = 20.0f;
        viewDir = new Vector3(0, 0, 0);
        experience = 0;
        effects = new ArrayList<>();
        IO.println("Initialised Player stats");
        EntityManager.getInstance().add(this);
    }

    @Override
    public float getHealth() {
        return currentHealth;
    }

    @Override
    public float setHealth(float health) {
        currentHealth-=health;
        IO.println("set Health");
        return currentHealth;
    }

    @Override
    public void addEffect(String effectid, int strength, int duration) {
        EffectType effect = Effect.getEffect(effectid);
        effects.add(new EffectBehavior(effect, strength, duration));
        IO.println("added effect");
    }

    @Override
    public void clearEffect(EffectType effect) {
        EffectBehavior found = null;
        for (EffectBehavior e : effects) {
            if (e.effect().id().equals(effect.id())) {
                found = e;
                break;
            }
        }
        effects.remove(found);
        IO.println("removed effects");
    }

    @Override
    public Vector3 getDimensions() {
        return size;
    }

    @Override
    public String getEntityId() {
        IO.println("got Entity id");
        return id;
    }

    @Override
    public void damage(float amount) {
        currentHealth -= amount;
    }
    @Override
    public List<EffectBehavior> getEffects() {
        return effects;
    }
}
