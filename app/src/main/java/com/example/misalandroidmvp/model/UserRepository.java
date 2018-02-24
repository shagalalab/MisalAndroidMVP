package com.example.misalandroidmvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atabek on 02/24/2018.
 */

public class UserRepository {
    private List<User> userList = new ArrayList<>();
    private static UserRepository instance;

    private UserRepository() {
        initUsers();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }

        return instance;
    }

    private void initUsers() {
        userList.add(new User(1, "user", "password", "User Passwordovich"));
        userList.add(new User(2, "admin", "qwerty", "Admin Qwertyevich"));
        userList.add(new User(3, "satibaldi", "miltiqbaev", "Satibaldi Miltiqbaevich"));
    }

    public int login(String username, String password) {
        for (User user : userList) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                return user.getId();
            }
        }

        return User.USER_NOT_FOUND;
    }

    public User findUserById(int userId) {
        for (User user : userList) {
            if (userId == user.getId()) {
                return user;
            }
        }

        return new User();
    }
}
