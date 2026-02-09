package org.mmcc;

public record FullEffect(
        EffectType effect,
        int strength,
        int duration
) {}
