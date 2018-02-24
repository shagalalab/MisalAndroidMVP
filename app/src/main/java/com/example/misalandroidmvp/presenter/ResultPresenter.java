package com.example.misalandroidmvp.presenter;

import com.example.misalandroidmvp.model.User;
import com.example.misalandroidmvp.model.UserRepository;
import com.example.misalandroidmvp.view.result.ResultView;

/**
 * Created by atabek on 02/24/2018.
 */

public class ResultPresenter {
    private ResultView view;
    private UserRepository repository;

    public ResultPresenter(ResultView view, UserRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void findUserById(int id) {
        User user = repository.findUserById(id);
        view.showUserDetails(user);
    }
}
