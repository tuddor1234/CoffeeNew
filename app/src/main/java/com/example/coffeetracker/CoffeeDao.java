package com.example.coffeetracker;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
public interface CoffeeDao {

    @Query("SELECT * FROM coffee")
    LiveData<List<Coffee>> getCoffeeList();

    @Insert
    void insert(Coffee coffee);

    @Query("SELECT COUNT(*) FROM coffee WHERE date BETWEEN :dayStart AND :dayEnd")
    LiveData<Integer> getCoffeeNr(Date dayStart, Date dayEnd);

    @Query("SELECT SUM(cafeine) FROM coffee WHERE date BETWEEN :dayStart AND :dayEnd")
    LiveData<Integer> getCaffeine(Date dayStart, Date dayEnd);

//    @Update
//    void updateCoffee(Coffee coffee);
//
//    @Delete
//    void deleteCoffee(Coffee coffee);
}
