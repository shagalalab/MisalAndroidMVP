package com.example.misalandroidmvp.view.login;

/**
 * Created by atabek on 02/23/2018.
 */

public interface LoginView {
    void showUsernameError(int error);
    void hideUsernameError();
    void showPasswordError(int error);
    void hidePasswordError();
    void enableLoginButton();
    void disableLoginButton();
    void goToResultScreen(int userId);
}
