package org.mmcc;


public class Inventory {
    private static Slot[][] grid;
    static void init() {
        grid = new Slot[16][4];
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 4; y++) {
                grid[x][y] = new Slot(Item.empty, 0);
                // IO.println("Initiated slot ["+x+", "+y+"]");
            }
        }
        IO.println("Initiated all slots");
    }
    static void changeContent(int x, int y, String item, int amount) {
        if (x < 0 || x >= 16 || y < 0 || y >= 4) return;
        if (!Item.hasFinal(Item.class, item)) return;
        ItemRecord record = Item.getItem(item);
        if (record == null) return;
        grid[x][y].setItem(record);
        grid [x][y].setAmount(amount);
    }
    static ItemRecord getContent(int x, int y) {
        IO.println(grid[x][y].getItem().id()+" "+grid[x][y].getAmount());
        return grid[x][y].getItem();
    }

}
