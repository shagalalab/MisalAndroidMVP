package com.example.misalandroidmvp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by atabek on 02/24/2018.
 */

public class UserRepositoryTest {
    private UserRepository repository;

    @Before
    public void setUp() {
        repository = new UserRepository();
    }

    @Test
    public void testLoginFailure() {
        assertEquals(User.USER_NOT_FOUND, repository.login("abcd", "efjh"));
    }

    @Test
    public void testLoginSuccess() {
        assertEquals(1, repository.login("user", "password"));
    }

    @Test
    public void testFindUserByIdFailure() {
        User user = repository.findUserById(User.USER_NOT_FOUND);
        assertEquals(user, new User());
    }

    @Test
    public void testFindUserByIdSuccess() {
        User user = repository.findUserById(1);
        assertEquals(user, new User(1, "user", "password", "User Passwordovich"));
    }
}