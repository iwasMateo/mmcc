package org.mmcc;

public class Slot {
    private ItemRecord item;
    private int amount;
    public Slot(ItemRecord item, int amount) {
        this.item = item;
        this.amount = amount;
    }
    public ItemRecord getItem() {
        return item;
    }
    public int getAmount() {
        return amount;
    }
    public String setItem(ItemRecord item){
        this.item = item;
        return "";
    }
    public int setAmount(int amount) {
        this.amount = amount;
        return 0;
    }
}
