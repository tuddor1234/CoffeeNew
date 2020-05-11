package com.example.coffeetracker;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coffeetracker.Coffee;

@Database(entities = Coffee.class, exportSchema = false, version = 1)
public abstract class CoffeeDatabase extends RoomDatabase {

    private static final String DB_NAME = "coffee_db";

    private static volatile CoffeeDatabase instance;

    public static synchronized CoffeeDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(), CoffeeDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
        }
        return instance;
    }


    public abstract CoffeeDao coffeeDao();

}
