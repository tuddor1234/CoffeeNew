package com.example.coffeetracker;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.coffeetracker.Coffee;
import com.example.coffeetracker.ui.Converters;

@Database(entities = Coffee.class, exportSchema = false, version = 3)
@TypeConverters({Converters.class})
public abstract class CoffeeDatabase extends RoomDatabase {

    public abstract CoffeeDao coffeeDao();

    private static final String DB_NAME = "coffee_database";

    private static volatile CoffeeDatabase instance;

    static CoffeeDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (CoffeeDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), CoffeeDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
                }
            }
        }
        return instance;
    }
}
