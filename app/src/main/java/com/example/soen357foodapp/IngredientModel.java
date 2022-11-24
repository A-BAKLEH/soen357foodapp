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

    public double iqtty; // ingredient quantity

    public String unit = "pcs"; // track measurement unit for ingredient, by default "pcs"

    public IngredientModel(String iname, double iqtty) {
        this.iid = iCount;
        this.iname = iname;
        this.iqtty = iqtty;
        iCount++;
    }

    public IngredientModel(String iname, double iqtty, String unit) {
        this.iid = iCount;
        this.iname = iname;
        this.iqtty = iqtty;
        this.unit = unit;
        iCount++;
    }
}
