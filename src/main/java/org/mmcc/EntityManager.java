package org.mmcc;
import java.util.Map;
import java.util.HashMap;

public class EntityManager {
    private final Map<String, Entity> entities = new HashMap<>();

    // Singleton instance
    private static final EntityManager instance = new EntityManager();

    private EntityManager() {} // private constructor

    public static EntityManager getInstance() {
        return instance;
    }

    public void add(Entity entity) {
        entities.put(entity.getId(), entity);
    }

    public Entity get(String id) {
        return entities.get(id);
    }
}
