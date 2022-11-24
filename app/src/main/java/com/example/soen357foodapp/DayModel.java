package com.example.soen357foodapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * David-Salomon Dahan
 * Filename: DayModel.java
 * Creation: 2022-11-23
 */
public class DayModel {
    // POTENTIALLY USELESS CLASS, BASED ON IMPLEMENTATION DECISIONS TO BE MADE LATER

    public static int dCount; // tracks number of days in the system

    public int did; // day ID

    public Date date; // date of the day

    public ArrayList<MealModel> mealsInDay; // meals for the day

    public DayModel(int did, Date date, ArrayList<MealModel> mealsInDay) {
        this.did = did;
        this.date = date;
        this.mealsInDay = mealsInDay;
    }

    public DayModel(Date date) {
        this.did = dCount;
        this.date = date;
        this.mealsInDay = new ArrayList<>();
        dCount++;
    }

    // add a meal for the day
    public void addMealInDay(MealModel meal) {
        this.mealsInDay.add(meal);
    }
}
