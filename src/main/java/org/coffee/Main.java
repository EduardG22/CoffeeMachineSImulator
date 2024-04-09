package org.coffee;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    buyCoffee(scanner);
                    break;
                case "fill":
                    fillSupplies(scanner);
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }


    }

    public static void printState() {
        System.out.println("\nThe coffee machine has: ");
        System.out.printf("%d ml of water\n" +
                        "%d ml of milk\n" +
                        "%d g of coffee beans\n" +
                        "%d disposable cups\n" +
                        "$%d of money\n",
                water,
                milk,
                coffeeBeans,
                disposableCups,
                money);
    }

    private static void buyCoffee(Scanner scanner) {
        boolean isChoosing = true;

        while (isChoosing) {
            System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":
                    //Espresso
                    makeCoffee(250, 0, 16, 4);
                    isChoosing = false;
                    break;
                case "2":
                    //Latte
                    makeCoffee(350, 75, 20, 7);
                    isChoosing = false;
                    break;
                case "3":
                    //Cappuccino
                    makeCoffee(200, 100, 12, 6);
                    isChoosing = false;
                    break;
                case "back":
                    isChoosing = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private static void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost ) {
        if(water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            money += cost;
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
        } else {
            String message = "Sorry, not enough ";
            if (water < waterNeeded) {
                message += "water";
            } else if (milk < milkNeeded) {
                message += "milk";
            } else if (coffeeBeans < coffeeBeansNeeded) {
                message += "coffee beans";
            } else if (disposableCups < 1) {
                message += "disposable cups";
            }
            System.out.println(message + "!");
        }
    }

    private static void fillSupplies(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int waterAdded = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milkAdded = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeansAdded = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int disposableCupsAdded = scanner.nextInt();

        water += waterAdded;
        milk += milkAdded;
        coffeeBeans += coffeeBeansAdded;
        disposableCups += disposableCupsAdded;
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money + "\n");
        money -= money;
    }
}