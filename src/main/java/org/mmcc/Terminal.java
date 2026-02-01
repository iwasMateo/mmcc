package org.mmcc;

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
                case "Effect":
                    switch (args[0]) {
                        case "add":
                            if(args.length != 5) {
                                IO.println("Incorrect Syntax");
                                break;
                            }
                            Entity entity= EntityManager.getInstance().get(args[1]);
                            EffectType effect = Effect.getEffect(args[2]);
                            int strength = Integer.parseInt(args[3]);
                            int duration = Integer.parseInt(args[4]);
                            entity.addEffect(effect, strength, duration);
                            break;
                        case "clear":
                            if (args.length != 3) {
                                IO.println("Incorrect Syntax");
                                break;
                            }
                            Entity entity1 = EntityManager.getInstance().get(args[1]);
                            String EffectId = args[2];
                            EffectType effectType = Effect.getEffect(EffectId);
                            if (effectType != null) {
                                entity1.clearEffect(effectType);
                            } else {
                                IO.println("Effect doesn't exist");
                                break;
                        }
                        case "get":
                            if (args.length != 2) {
                                IO.println("Incorrect Syntax");
                                break;
                            }
                            Entity entity2 = EntityManager.getInstance().get(args[1]);
                            IO.println(entity2.getEffects());
                            break;
                    }

            }
        }
        scanner.close();
    }
}
