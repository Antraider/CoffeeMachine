package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    final int WATER_NEED = 200;
    final int MILK_NEED = 50;
    final int BEANS_NEED = 15;
    int waterHas;
    int milkHas;
    int beansHas;
    int coffeeNeed;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.initCoffeeMachine();
        coffeeMachine.calculateCoffee();
    }

    private void initCoffeeMachine() {
        System.out.println("Write how many ml of water the coffee" +
                " machine has: ");
        this.waterHas = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee" +
                " machine has: ");
        this.milkHas = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans" +
                " the coffee machine has: ");
        this.beansHas = scanner.nextInt();
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
