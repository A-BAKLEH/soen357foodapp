package com.example.soen357foodapp;

/**
 * David-Salomon Dahan
 * Filename: IngredientModel.java
 * Creation: 2022-11-23
 */
public class IngredientModel {
    public int iid; // ingredient ID

    public String iname; // ingredient name

    public int iqtty; // ingredient quantity

    public IngredientModel(int iid, String iname, int iqtty) {
        this.iid = iid;
        this.iname = iname;
        this.iqtty = iqtty;
    }
}
