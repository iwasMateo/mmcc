package org.mmcc;

public class Main {
    static void main(String[] args) {
        IO.println(String.format("Hello and welcome!"));
        Inventory.init();
        Player player = new Player();
        player.init();
        Terminal.commandRead();
    }
}
