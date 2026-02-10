package org.mmcc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class Player implements Entity, StandardPlayer{
=======
public class Player implements Entity{
>>>>>>> 16f9350 (Rename to player)
    public float maxHealth = 20;
    public float currentHealth;
    public Vector3 dirSpeed;
    public float hunger;
    public Vector3 viewDir;
    public int experience;
    public List<FullEffect> effects;
    public Vector3 size = new Vector3(0.8f, 1.8f, 0.8f);
    public String id = "player";
    public int selectslot = 0;

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
        //IO.println("set Health");
        return currentHealth;
    }

    @Override
    public void modEffect(String effectid, int strength, int duration) {
        for (FullEffect e : effects) {
            if (e.effect().id().equals(effectid)) {
                effects.remove(e);
            }
        }
        EffectType effect = Effect.getEffect(effectid);
        effects.add(new FullEffect(effect, strength, duration));
        //IO.println("added effect");
    }

    @Override
    public void clearEffect(EffectType effect) {
        FullEffect found = null;
        for (FullEffect e : effects) {
            if (e.effect().id().equals(effect.id())) {
                found = e;
                break;
            }
        }
        effects.remove(found);
        //IO.println("removed effects");
    }

    @Override
    public Vector3 getDimensions() {
        return size;
    }

    @Override
    public String getEntityId() {
        //IO.println("got Entity id");
        return id;
    }

    @Override
    public void damage(float amount) {
        currentHealth -= amount;
    }
    @Override
    public List<FullEffect> getEffects() {
        return effects;
    }

    @Override
    public Slot getHand() {
        return null;
    }

    @Override
    public List<Slot> getHotbar() {
        ArrayList<Slot> hotbar = null;
        for (int i = 0; i<16; i++) {
            hotbar.add(Inventory.getSlot(i, 0));
        }
        return hotbar;
    }

    @Override
    public void useHand() {
        if (Inventory.getContent(selectslot, 0).edible()) {
            eatHand();
        }
    }

    @Override
    public void eatHand() {
        int handamount = Inventory.getSlot(selectslot, 0).getAmount();
        if (handamount > 1) {
            Inventory.getSlot(selectslot, 0).setAmount(handamount-1);
        } else {
            Inventory.getSlot(selectslot, 0).setItem(Item.empty);
            Inventory.getSlot(selectslot,0).setAmount(0);
        }
    }
}
