package org.example;

public class Main {
    static void main() {
        IO.println(String.format("Hello and welcome!"));
        Inventory.init();
        while (true) {
            Terminal.commandRead();
        }
    }
}
