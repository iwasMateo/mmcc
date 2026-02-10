package org.mmcc;

import java.util.List;

public interface StandardPlayer {
    public Slot getHand();
    public List<Slot> getHotbar();
    public void useHand();
    public void eatHand();
}
