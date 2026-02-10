package org.mmcc;

public class Main {
    static void main(String[] args) {
        IO.println(String.format("Hello and welcome!"));
        Inventory.init();
        PlayerStatus player = new PlayerStatus();
        player.init();
        Terminal.commandRead();
    }
}
