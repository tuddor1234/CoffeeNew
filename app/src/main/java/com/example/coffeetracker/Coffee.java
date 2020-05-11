package com.example.coffeetracker;

import android.icu.text.SimpleDateFormat;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "coffee")
public class Coffee {

    @PrimaryKey(autoGenerate = false)
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
    private String date;


    public Coffee(int id, int type, int score, int cafeine, int sugar, int milk, String date) {
        this.type = type;
        this.cafeine = cafeine;
        this.sugar = sugar;
        this.milk = milk;
        this.id = id;
        this.date = date;



//        Date c = Calendar.getInstance().getTime();
//        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
//        this.date = df.form
//at(c);

       // ComputeScore();
    }

    public int getScore() {
        return score;
    }

//    public void ComputeScore() {
//        score = cafeine + sugar + milk;
//    }

    public int getCafeine() {
        return cafeine;
    }

    public int getMilk() {
        return milk;
    }

    public int getSugar() {
        return sugar;
    }

    public void setCafeine(int cafeine) {
        this.cafeine = cafeine;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }


    public static void drink()
    {
        System.out.println("GLGLGLGLGLGL");
    }


    @NonNull
    @Override
    public String toString() {
        return "Details" + "id:" + id + "type:" + type + "cofeine:" + cafeine ;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
