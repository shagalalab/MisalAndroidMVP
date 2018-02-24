package com.example.misalandroidmvp.presenter;

import com.example.misalandroidmvp.R;
import com.example.misalandroidmvp.model.User;
import com.example.misalandroidmvp.model.UserRepository;
import com.example.misalandroidmvp.view.login.LoginView;

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

public class LoginPresenterTest {
    private static final int USER_ID_VALID = 1;
    private static final String EMPTY = "";
    private static final String USERNAME_SHORT = "abc";
    private static final String USERNAME_VALID = "abcd";
    private static final String PASSWORD_SHORT = "qwert";
    private static final String PASSWORD_VALID = "qwerty";

    private LoginView viewMock;
    private UserRepository repositoryMock;
    private LoginPresenter presenter;

    @Before
    public void setUp() {
        viewMock = mock(LoginView.class);
        repositoryMock = mock(UserRepository.class);

        presenter = new LoginPresenter(viewMock, repositoryMock);
    }

    @Test
    public void testValidateEmptyUsername() {
        presenter.login(EMPTY, EMPTY);

        verify(viewMock, times(1)).hideUsernameError();
        verify(viewMock, times(1)).hidePasswordError();
        verify(viewMock, times(1)).showUsernameError(R.string.empty_username);

        verifyNoMoreInteractions(viewMock);
    }

    @Test
    public void testValidateShortUsername() {
        presenter.login(USERNAME_SHORT, EMPTY);

        verify(viewMock, times(1)).hideUsernameError();
        verify(viewMock, times(1)).hidePasswordError();
        verify(viewMock, times(1)).showUsernameError(R.string.short_username);

        verifyNoMoreInteractions(viewMock);
    }

    @Test
    public void testValidateEmptyPassword() {
        presenter.login(USERNAME_VALID, EMPTY);

        verify(viewMock, times(1)).hideUsernameError();
        verify(viewMock, times(1)).hidePasswordError();
        verify(viewMock, times(1)).showPasswordError(R.string.empty_password);

        verifyNoMoreInteractions(viewMock);
    }

    @Test
    public void testValidateShortPassword() {
        presenter.login(USERNAME_VALID, PASSWORD_SHORT);

        verify(viewMock, times(1)).hideUsernameError();
        verify(viewMock, times(1)).hidePasswordError();
        verify(viewMock, times(1)).showPasswordError(R.string.short_password);

        verifyNoMoreInteractions(viewMock);
    }

    @Test
    public void testValidateUsernamePasswordNotMatch() {
        when(repositoryMock.login(USERNAME_VALID, PASSWORD_VALID)).thenReturn(User.USER_NOT_FOUND);
        presenter.login(USERNAME_VALID, PASSWORD_VALID);

        verify(viewMock, times(1)).hideUsernameError();
        verify(viewMock, times(1)).hidePasswordError();
        verify(viewMock, times(1)).showPasswordError(R.string.username_password_not_match);

        verifyNoMoreInteractions(viewMock);
    }

    @Test
    public void testValidateSuccess() {
        when(repositoryMock.login(USERNAME_VALID, PASSWORD_VALID)).thenReturn(USER_ID_VALID);
        presenter.login(USERNAME_VALID, PASSWORD_VALID);

        verify(viewMock, times(1)).hideUsernameError();
        verify(viewMock, times(1)).hidePasswordError();
        verify(viewMock, times(1)).goToResultScreen(USER_ID_VALID);

        verifyNoMoreInteractions(viewMock);
    }



}