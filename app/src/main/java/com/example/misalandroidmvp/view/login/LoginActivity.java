package com.example.misalandroidmvp.view.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.misalandroidmvp.R;
import com.example.misalandroidmvp.model.User;
import com.example.misalandroidmvp.model.UserRepository;
import com.example.misalandroidmvp.presenter.LoginPresenter;
import com.example.misalandroidmvp.view.result.ResultActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText username;
    private TextView usernameError;
    private EditText password;
    private TextView passwordError;
    private Button login;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        usernameError = findViewById(R.id.username_error);
        password = findViewById(R.id.password);
        passwordError = findViewById(R.id.password_error);
        login = findViewById(R.id.login);
        login.setOnClickListener(loginClickListener);

        presenter = new LoginPresenter(this, new UserRepository());
    }

    private View.OnClickListener loginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.login(username.getText().toString(), password.getText().toString());
        }
    };

    @Override
    public void showUsernameError(int error) {
        username.requestFocus();
        usernameError.setVisibility(View.VISIBLE);
        usernameError.setText(error);
    }

    @Override
    public void hideUsernameError() {
        usernameError.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showPasswordError(int error) {
        password.requestFocus();
        passwordError.setVisibility(View.VISIBLE);
        passwordError.setText(error);
    }

    @Override
    public void hidePasswordError() {
        passwordError.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enableLoginButton() {
        login.setEnabled(true);
    }

    @Override
    public void disableLoginButton() {
        login.setEnabled(false);
    }

    @Override
    public void goToResultScreen(int userId) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(User.USER_ID, userId);
        startActivity(intent);
    }
}
