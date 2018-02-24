package com.example.misalandroidmvp.view.result;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.misalandroidmvp.R;
import com.example.misalandroidmvp.model.User;
import com.example.misalandroidmvp.model.UserRepository;
import com.example.misalandroidmvp.presenter.ResultPresenter;

/**
 * Created by atabek on 02/24/2018.
 */

public class ResultActivity extends AppCompatActivity implements ResultView {
    private ResultPresenter presenter;
    private TextView userId;
    private TextView username;
    private TextView password;
    private TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        userId = findViewById(R.id.result_user_id);
        username = findViewById(R.id.result_username);
        password = findViewById(R.id.result_password);
        name = findViewById(R.id.result_name);

        presenter = new ResultPresenter(this, UserRepository.getInstance());

        int userId = getIntent().getIntExtra(User.USER_ID, User.USER_NOT_FOUND);
        presenter.findUserById(userId);
    }

    @Override
    public void showUserDetails(User user) {
        userId.setText(getString(R.string.user_details_id, user.getId()));
        username.setText(getString(R.string.user_details_username, user.getUsername()));
        password.setText(getString(R.string.user_details_password, user.getPassword().replaceAll("\\w", "*")));
        name.setText(getString(R.string.user_details_name, user.getName()));
    }
}
