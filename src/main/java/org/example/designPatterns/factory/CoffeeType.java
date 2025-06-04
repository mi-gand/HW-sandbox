package org.example.designPatterns.factory;

import java.util.function.Supplier;

enum CoffeeType{
    AMERICANO(Americano::new),
    ESPRESSO(Espresso::new);

    private final Supplier<Coffee> supplier;

    CoffeeType(Supplier<Coffee> supplier){
        this.supplier = supplier;
    }

    public Coffee getCoffee() {
        return supplier.get();
    }
}