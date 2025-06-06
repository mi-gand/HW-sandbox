package org.example.designPatterns.factory;

import static org.example.designPatterns.factory.CoffeeType.*;

public abstract class Coffee {
    public abstract void create();

    public static void main(String[] args) {
        CoffeeMachine.start(ESPRESSO);
        CoffeeMachine.start(AMERICANO);
        CoffeeMachine.start(LATTE);
    }
}

class Americano extends Coffee {
    public void create() {
        System.out.println("Actions for Americano");
    }
}

class Espresso extends Coffee {
    public void create() {
        System.out.println("Actions for Espresso");
    }
}

class Latte extends Coffee {
    public void create() {
        System.out.println("Actions for Latte");
    }
}

class CoffeeMachine {
    public static void start(CoffeeType order) {
        firstStep();
        CoffeeFabric.getCoffee(order).create();
        lastStep();
    }

    private static void firstStep() {
        System.out.println("turned on and rinsed the coffee machine");
    }

    private static void lastStep() {
        System.out.println("coffee is ready");
    }
}

class CoffeeFabric {
    public static Coffee getCoffee(CoffeeType coffeeType) {
        return switch (coffeeType) {
            case ESPRESSO -> ESPRESSO.getCoffee();
            case AMERICANO -> AMERICANO.getCoffee();
            case LATTE -> LATTE.getCoffee();
        };
    }
}

