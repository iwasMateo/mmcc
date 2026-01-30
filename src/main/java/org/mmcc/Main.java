package org.mmcc;

public class Main {
    public static void main(String[] args) {
        IO.println(String.format("Hello and welcome!"));
        Inventory.init();
        Terminal.commandRead();
    }
}
