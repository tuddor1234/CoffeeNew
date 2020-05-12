package com.example.coffeetracker;

import android.app.Activity;
import android.app.Application;
import android.icu.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

public class Profile {

    private String name = new String();
    private int height;
    private int weight;
    private int age;
    private boolean isMale;



    public static Profile INSTANCE = new Profile();
    private static Map<String, Vector<Coffee> > history = new HashMap<>();

    private Profile()
    {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new String(name);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }




    public static void Drink(Coffee coffee)
    {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        Vector<Coffee> today = history.get(formattedDate);
        today.add(coffee);

    }

    private void newDay()
    {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        history.put(formattedDate,new Vector<Coffee>());
    }

    private void ComputeTodayScore()
    {
        int score  = 0;
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        Vector<Coffee> today = history.get(formattedDate);

        Iterator it = today.iterator();

        while(it.hasNext())
        {
            // @TODO ADD TO COMPUTE THE SCORE
            System.out.println(it.next());

        }

    }

    public static void main(String[] args) {

        CoffeeFactory cf = new CoffeeFactory();

        Coffee coffee  = cf.createCoffee("LARGE");

        CoffeeDatabase database  = CoffeeDatabase.getInstance(getApplicationContext());

        database.coffeeDao().insert(coffee);
        System.out.println("--------------------------");
        System.out.println(database.coffeeDao().getCoffeeList());
        System.out.println("--------------------------");
    }





}




