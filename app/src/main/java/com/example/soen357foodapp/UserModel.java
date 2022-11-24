package com.example.soen357foodapp;

/**
 * David-Salomon Dahan
 * Filename: UserModel.java
 * Creation: 2022-11-23
 */
public class UserModel {
    public static int uCount;

    public int uid;

    public String passwd;

    public String fname, lname;

    public UserModel(String fname, String lname, String passwd) {
        this.uid = uCount;
        this.fname = fname;
        this.lname = lname;
        this.passwd = passwd;
        uCount++;
    }
}
