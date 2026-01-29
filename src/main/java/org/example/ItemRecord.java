package org.example;

public record ItemRecord(
        String id,
        String prettyName,
        int maxStack,
        boolean edible,
        float eatSpeed
) {}

