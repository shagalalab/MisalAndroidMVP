package com.example.misalandroidmvp.model;

/**
 * Created by atabek on 02/24/2018.
 */

public class User {
    public static final int USER_NOT_FOUND = -1;
    public static final String USER_ID = "user_id";

    private int id;
    private String username;
    private String password;
    private String name;

    User() {
        this.id = USER_NOT_FOUND;
        this.username = "";
        this.password = "";
        this.name = "";
    }

    User(int id, String username, String password, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
