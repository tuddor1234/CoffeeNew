package com.example.coffeetracker;

public class MediumCoffee extends Coffee {

    public static MediumCoffee Instance = new MediumCoffee(20,0,0);

    private MediumCoffee(int caffeine, int sugar, int milk) {
        super(caffeine, sugar, milk);
    }


    @Override
    public String toString() {
        String s =  super.toString();
        return s + "medium";
    }
}
