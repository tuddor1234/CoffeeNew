package com.example.coffeetracker;

import android.icu.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class CoffeeFactory {

    private static int nextID = 0;

    public Coffee createCoffee(String type)
    {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        if(type == null) return  null;

        nextID++;
        if(type.equalsIgnoreCase("SMALL"))
        {
            // SMALL COFFEE
            return new Coffee(nextID, 0,10,10,0,0, formattedDate );
        }
        else if(type.equalsIgnoreCase("MEDIUM"))
        {
            // SMALL COFFEE
            return new Coffee(nextID, 0,20,20,0,0, formattedDate );
        }
        else if(type.equalsIgnoreCase("LARGE"))
        {
            // SMALL COFFEE
            return new Coffee(nextID, 0,30,30,0,0, formattedDate );
        }

        else return null;

    }



}
