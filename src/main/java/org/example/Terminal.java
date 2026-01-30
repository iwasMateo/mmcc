package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Terminal {
    public static void commandRead () {
        Scanner scanner;
        scanner = new Scanner(System.in); // take text input
        while (true) {

            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.isBlank()) continue;
            if (input.equalsIgnoreCase("exit")) break;
            String[] parts = input.split("\\s+");
            String command = parts[0];
            String[] args = Arrays.copyOfRange(parts, 1, parts.length);
            switch (command) {
                case "Inventory":
                    switch (args[0]) {
                        case "set":
                            if (args.length < 5) {
                                IO.println("Incorrect Syntax");
                                break;
                            }

                            int x = Integer.parseInt(args[1]);
                            // IO.println(x);
                            int y = Integer.parseInt(args[2]);
                            // IO.println(y);
                            ItemRecord item = Item.getItem(args[3]);
                            // IO.println(item.id());
                            int amount = Integer.parseInt(args[4]);
                            // IO.println(amount);

                            if (
                                    x >= 0 && x < 16 &&
                                            y >= 0 && y < 4 &&
                                            item != null &&
                                            amount > 0 &&
                                            amount <= item.maxStack()
                            ) {
                                Inventory.changeContent(x, y, args[3], amount);
                            } else {
                                IO.println("Incorrect Syntax");
                            }
                            break;
                        case "get":
                            Inventory.getContent(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                            break;
                    }

            }
        }
        scanner.close();
    }
}
