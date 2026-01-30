package org.mmcc;
import java.util.ArrayList;
import java.util.List;

public class PlayerStatus {
    public float maxHealth = 20;
    public float currentHealth;
    public Vector3 dirSpeed;
    public float hunger;
    public Vector3 viewDir;
    public int experience;
    public List<EffectType> effects;
    public Vector3 size = new Vector3(0.8f, 1.8f, 0.8f);
        public void init () {
        currentHealth = maxHealth;
        dirSpeed = new Vector3(0, 0, 0);
        hunger = 20.0f;
        viewDir = new Vector3(0, 0, 0);
        experience = 0;
        effects = new ArrayList<>();
        IO.println("Initialised Player stats");
    }

    public void damage(float amount) {
        currentHealth -= amount;
    }
}
