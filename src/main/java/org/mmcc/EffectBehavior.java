package org.mmcc;

public record EffectBehavior(
        EffectType effect,
        int strength,
        int duration
) {
}
