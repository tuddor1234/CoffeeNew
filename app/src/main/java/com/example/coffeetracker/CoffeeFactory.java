package com.example.coffeetracker;

import java.util.Calendar;
import java.util.Date;

public class CoffeeFactory {

    public Coffee createCoffee(String type) {
        Date date = Calendar.getInstance().getTime();

        if (type == null) return null;

        if (type.equalsIgnoreCase("SMALL")) {
            // Small coffee
            return new Coffee(0, 10, 40, 0, 0, date);

        } else if (type.equalsIgnoreCase("MEDIUM")) {
            // Medium coffee
            return new Coffee(1, 20, 60, 0, 0, date);

        } else if (type.equalsIgnoreCase("LARGE")) {
            // Small coffee
            return new Coffee(2, 30, 80, 0, 0, date);
        } else {
            return null;
        }
    }
}
