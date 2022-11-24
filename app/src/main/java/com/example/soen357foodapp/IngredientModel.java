package com.example.soen357foodapp;

/**
 * David-Salomon Dahan
 * Filename: IngredientModel.java
 * Creation: 2022-11-23
 */
public class IngredientModel {
    public static int iCount; // tracks the number of ingredients in the system

    public int iid; // ingredient ID

    public String iname; // ingredient name

    public int iqtty; // ingredient quantity

    public IngredientModel(String iname, int iqtty) {
        this.iid = iCount;
        this.iname = iname;
        this.iqtty = iqtty;
        iCount++;
    }
}
