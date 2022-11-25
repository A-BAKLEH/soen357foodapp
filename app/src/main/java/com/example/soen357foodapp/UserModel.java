package com.example.soen357foodapp;

/**
 * David-Salomon Dahan
 * Filename: UserModel.java
 * Creation: 2022-11-23
 */
public class UserModel {
    public static int uCount; // number of users in the system

    public int uid; // user ID

    public String passwd; // user's password in cleartext

    public String fname, lname; // first and last name of user

    public String email;

    public UserModel(String fname, String lname, String email,String passwd) {
        this.uid = uCount;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.passwd = passwd;
        uCount++; // update number of users in the system
    }
}
