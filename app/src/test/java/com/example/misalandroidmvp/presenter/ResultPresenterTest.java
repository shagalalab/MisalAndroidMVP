package com.example.misalandroidmvp.presenter;

import com.example.misalandroidmvp.model.User;
import com.example.misalandroidmvp.model.UserRepository;
import com.example.misalandroidmvp.view.result.ResultView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by atabek on 02/24/2018.
 */

public class ResultPresenterTest {
    private ResultView viewMock;
    private UserRepository repositoryMock;
    private User userMock;
    private ResultPresenter presenter;

    @Before
    public void setUp() {
        viewMock = mock(ResultView.class);
        repositoryMock = mock(UserRepository.class);
        userMock = mock(User.class);
        presenter = new ResultPresenter(viewMock, repositoryMock);
    }

    @Test
    public void testFindUserById() {
        when(repositoryMock.findUserById(1)).thenReturn(userMock);

        presenter.findUserById(1);

        verify(viewMock, times(1)).showUserDetails(userMock);
        verifyNoMoreInteractions(viewMock);
    }
}
