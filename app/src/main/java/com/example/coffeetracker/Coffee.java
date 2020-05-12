package com.example.coffeetracker;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "coffee")
public class Coffee {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "score")
    private int score;

    @ColumnInfo(name = "cafeine")
    private int cafeine;

    @ColumnInfo(name = "sugar")
    private int sugar = 0;

    @ColumnInfo(name = "milk")
    private int milk = 0;

    @ColumnInfo(name = "date")
    private Date date;


    public Coffee(int type, int score, int cafeine, int sugar, int milk, Date date) {
        this.type = type;
        this.cafeine = cafeine;
        this.sugar = sugar;
        this.milk = milk;
        this.date = date;

        ComputeScore();
    }

    public int getScore() {
        return this.score;
    }

    public void ComputeScore() {
        score = cafeine + sugar + milk;
    }

    public int getCafeine() {
        return this.cafeine;
    }

    public void setCafeine(int cafeine) {
        this.cafeine = cafeine;
    }

    public int getMilk() {
        return this.milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getSugar() {
        return this.sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public Date getDate() {
        return this.date;
    }


    public int getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void drink() {
        System.out.println("GLGLGLGLGLGL");
    }

    @NonNull
    @Override
    public String toString() {
        return "Details" + "id:" + id + "type:" + type + "cofeine:" + cafeine;
    }
}
