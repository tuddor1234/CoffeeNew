package com.example.coffeetracker;

import androidx.annotation.NonNull;

public class Coffee {

    private int score;

    private int cafeine;
    private int sugar = 0;
    private int milk = 0;

    private boolean hasLiqure;

    protected Coffee(int cofeine, int sugar , int milk) {

        this.cafeine = cofeine;
        this.sugar = sugar;
        this.milk = milk;

        ComputeScore();
    }

    public int getScore() {
        return score;
    }

    public void ComputeScore() {
        score = cafeine + sugar + milk;
    }

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
        return "Coffee type: ";
    }
}
