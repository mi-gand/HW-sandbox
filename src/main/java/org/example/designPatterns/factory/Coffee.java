package org.example.designPatterns.factory;

import static org.example.designPatterns.factory.CoffeeType.AMERICANO;
import static org.example.designPatterns.factory.CoffeeType.ESPRESSO;

public abstract class Coffee {
    public abstract void create();

    public static void main(String[] args) {
        CoffeeMachine.start(ESPRESSO);
        CoffeeMachine.start(AMERICANO);
    }
}

class Americano extends Coffee {
    public void create(){
        System.out.println("Actions for Americano");
    }
}

class Espresso extends Coffee{
    public void create(){
        System.out.println("Actions for Espresso");
    }
}

class CoffeeMachine {
    public static void start(CoffeeType order){
        firstStep();
        CoffeeFabric.getCoffee(order).create();
        lastStep();
    }
    private static void firstStep(){
        System.out.println("turned on and rinsed the coffee machine");
    }
    private static void lastStep(){
        System.out.println("coffee is ready");
    }
}

class CoffeeFabric{
    public static Coffee getCoffee(CoffeeType coffeeType){
        Coffee order;
        switch (coffeeType){
            case ESPRESSO -> order = ESPRESSO.getCoffee();
            case AMERICANO -> order = AMERICANO.getCoffee();
            default -> throw new IllegalArgumentException("Wrong type");
        }
        return order;
    }
}

