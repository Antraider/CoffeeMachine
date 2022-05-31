package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    final int WATER_NEED = 200;
    final int MILK_NEED = 50;
    final int BEANS_NEED = 15;
    int money = 550;
    int waterHas = 400;
    int milkHas = 540;
    int beansHas = 120;
    int disCups = 9;
    int coffeeNeed;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        //coffeeMachine.calculateCoffee();
        coffeeMachine.showMenu();
    }

    private void showCoffeeMachineState() {
        System.out.println("The coffee machine has:");
        System.out.println(waterHas + " ml of water");
        System.out.println(milkHas + " ml of milk");
        System.out.println(beansHas + " g of coffee beans");
        System.out.println(disCups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }

    public void showMenu(){
        showCoffeeMachineState();
        System.out.println("Write action (buy, fill, take): ");
        switch (scanner.next()) {
            case "buy": {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                buy(scanner.next());
                break;
            }
            case "fill": {
                fillCoffeeMachine();
                break;
            }
            case "take": {
                takeOutTheMoney();
                break;
            }
            default: {
                System.out.println("Wrong action");
            }
        }
    }

    private void takeOutTheMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
        showCoffeeMachineState();
    }

    private void fillCoffeeMachine() {
        System.out.println("Write how many ml of water you want to add: ");
        waterHas += Integer.parseInt(scanner.next());
        System.out.println("Write how many ml of milk you want to add: ");
        milkHas += Integer.parseInt(scanner.next());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beansHas += Integer.parseInt(scanner.next());
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        disCups += Integer.parseInt(scanner.next());
        showCoffeeMachineState();
    }

    private void buy(String coffee) {
        switch (coffee) {
            case "1": {
                waterHas -= 250;
                beansHas -= 16;
                disCups--;
                money += 4;
                break;
            }
            case "2": {
                waterHas -= 350;
                milkHas -= 75;
                beansHas -= 20;
                disCups--;
                money += 7;
                break;
            }
            case "3": {
                waterHas -= 200;
                milkHas -= 100;
                beansHas -= 12;
                disCups--;
                money += 6;
                break;
            }
            default: {

            }
        }
        showCoffeeMachineState();
    }

    private void calculateCoffee() {
        System.out.println("Write how many cups of coffee you will need: ");
        this.coffeeNeed = scanner.nextInt();
        int maxWater = waterHas / WATER_NEED;
        int maxMilk = milkHas / MILK_NEED;
        int maxBeans = beansHas / BEANS_NEED;
        int maxCoffee;
        if (maxWater <= maxMilk) {
            if (maxWater <= maxBeans) { maxCoffee = maxWater;
            } else { maxCoffee = maxBeans; }

        } else if (maxMilk <= maxBeans) { maxCoffee = maxMilk; }
        else { maxCoffee = maxBeans;}

        if (coffeeNeed == maxCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (coffeeNeed > maxCoffee) {
            System.out.println("No, I can make only " + maxCoffee
                    + " cup(s) of coffee");
        }   else {
            System.out.println("Yes, I can make that amount of coffee" +
                    " (and even " + (maxCoffee-coffeeNeed) +
                    " more than that)");
        }
    }
}
