package com.example.misalandroidmvp.presenter;

import com.example.misalandroidmvp.R;
import com.example.misalandroidmvp.model.User;
import com.example.misalandroidmvp.model.UserRepository;
import com.example.misalandroidmvp.view.login.LoginView;

/**
 * Created by atabek on 02/23/2018.
 */

public class LoginPresenter {
    private static final int USERNAME_MIN_LENGTH = 4;
    private static final int PASSWORD_MIN_LENGTH = 6;

    private LoginView view;
    private UserRepository repository;

    public LoginPresenter(LoginView view, UserRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void login(String username, String password) {
        if (!validate(username, password)) return;

        int loginResult = repository.login(username, password);
        if (loginResult == User.USER_NOT_FOUND) {
            view.showPasswordError(R.string.username_password_not_match);
        } else {
            view.goToResultScreen(loginResult);
        }
    }

    private boolean validate(String username, String password) {
        view.hideUsernameError();
        view.hidePasswordError();

        if (username.isEmpty()) {
            view.showUsernameError(R.string.empty_username);
            return false;
        } else if (username.length() < USERNAME_MIN_LENGTH) {
            view.showUsernameError(R.string.short_username);
            return false;
        }

        if (password.isEmpty()) {
            view.showPasswordError(R.string.empty_password);
            return false;
        } else if (password.length() < PASSWORD_MIN_LENGTH) {
            view.showPasswordError(R.string.short_password);
            return false;
        }

        return true;
    }
}
