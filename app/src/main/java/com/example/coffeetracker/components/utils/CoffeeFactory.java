package com.example.coffeetracker.components.utils;

import com.example.coffeetracker.Coffee;

import java.util.Calendar;
import java.util.Date;

public class CoffeeFactory {

    // Default caffeine levels
    private int SMALL_CAFFEINE = 40;
    private int MEDIUM_CAFFEINE = 60;
    private int LARGE_CAFFEINE = 80;

    public Coffee createCoffee(String type) {
        Date date = Calendar.getInstance().getTime();

        int smallCaffeine = SMALL_CAFFEINE;
        int mediumCaffeine = MEDIUM_CAFFEINE;
        int largeCaffeine = LARGE_CAFFEINE;

        if (type.equalsIgnoreCase("SMALL")) {
            // Small coffee
            return new Coffee(0, 10, smallCaffeine, 0, 0, date);

        } else if (type.equalsIgnoreCase("MEDIUM")) {
            // Medium coffee
            return new Coffee(1, 20, mediumCaffeine, 0, 0, date);

        } else if (type.equalsIgnoreCase("LARGE")) {
            // Small coffee
            return new Coffee(2, 30, largeCaffeine, 0, 0, date);
        } else {
            return null;
        }
    }

    public int getSMALL_CAFFEINE() {
        return SMALL_CAFFEINE;
    }

    public void setSMALL_CAFFEINE(int SMALL_CAFFEINE) {
        this.SMALL_CAFFEINE = SMALL_CAFFEINE;
    }

    public int getMEDIUM_CAFFEINE() {
        return MEDIUM_CAFFEINE;
    }

    public void setMEDIUM_CAFFEINE(int MEDIUM_CAFFEINE) {
        this.MEDIUM_CAFFEINE = MEDIUM_CAFFEINE;
    }

    public int getLARGE_CAFFEINE() {
        return LARGE_CAFFEINE;
    }

    public void setLARGE_CAFFEINE(int LARGE_CAFFEINE) {
        this.LARGE_CAFFEINE = LARGE_CAFFEINE;
    }
}
