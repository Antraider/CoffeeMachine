package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int waterStored = 400;
        int milkStored = 540;
        int beansStored = 120;
        int disCupsStored = 9;
        int money = 550;
        int espressoPrice = 4;
        int lattePrice = 7;
        int cappuccinoPrice = 6;
        State state = State.CHOOSING_ACTION;





        InputHandler in = new InputHandler();
        while (true) {
            System.out.println("Write action (buy, fill, take):");
            state = State.CHOOSING_ACTION;

            switch (in.getStrInput()) {
                case "buy": {
                    state = State.CHOOSING_COFFEE;
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte," +
                            "3 - cappuccino back - to main menu:");
                    switch (in.getStrInput()) {
                        case "1": {
                            if (waterStored >= 250 && beansStored >= 16 && disCupsStored >= 1) {
                                waterStored -= 250;
                                beansStored -= 16;
                                money += espressoPrice;
                                disCupsStored -= 1;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                if (waterStored < 250) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (beansStored < 16) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (disCupsStored < 1) {
                                    System.out.println("Sorry, not enough disposable cups!");
                                }
                            }
                            break;

                        }
                        case "2": {
                            if (waterStored >= 350 && milkStored >= 75 && beansStored >= 20) {
                                waterStored -= 350;
                                milkStored -= 75;
                                beansStored -= 20;
                                money += lattePrice;
                                disCupsStored -= 1;
                                System.out.println("I have enough resources, making you a coffee!");
                            } else {
                                if (waterStored < 350) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (milkStored < 75) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (beansStored < 20) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (disCupsStored < 1) {
                                    System.out.println("Sorry, not enough disposable cups!");
                                }
                            }
                            break;

                        }
                        case "3": {
                            if (waterStored >= 200 && milkStored >= 100 && beansStored >= 12) {
                                waterStored -= 200;
                                milkStored -= 100;
                                beansStored -= 12;
                                money += cappuccinoPrice;
                                disCupsStored -= 1;
                            } else {
                                if (waterStored < 200) {
                                    System.out.println("Sorry, not enough water!");
                                }
                                if (milkStored < 100) {
                                    System.out.println("Sorry, not enough milk!");
                                }
                                if (beansStored < 12) {
                                    System.out.println("Sorry, not enough beans!");
                                }
                                if (disCupsStored < 1) {
                                    System.out.println("Sorry, not enough disposable cups!");
                                }
                            }
                            break;
                        }
                        case "back": {
                            break;
                        }
                    }
                    break;
                }
                case "fill": {
                    state = State.FILLING;
                    System.out.println("Write how many ml of water you want to add:");
                    waterStored += in.getIntInput();
                    System.out.println("Write how many ml of milk you want to add:");
                    milkStored += in.getIntInput();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    beansStored += in.getIntInput();
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    disCupsStored += in.getIntInput();
                    break;
                }
                case "take": {
                    state = State.TAKING_MONEY;
                    System.out.println("I gave you $" + money + "\n");
                    money = 0;
                    break;
                }
                case "remaining": {
                    state = State.SHOWING_REMAINING;
                    System.out.println("The coffee machine has:");
                    System.out.println(waterStored + " ml of water");
                    System.out.println(milkStored + " ml of milk");
                    System.out.println(beansStored + " g of coffee beans");
                    System.out.println(disCupsStored + " disposable cups");
                    System.out.println("$" + money + " of money");
                    break;
                }
                case "exit": {
                    System.exit(0);
                    break;
                }
            }
        }

    }
}
