package com.demo.menuapp.viewmodel;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import android.util.Pair;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.demo.menuapp.mock.MockMenuAppApi;
import com.demo.menuapp.mock.MockPreferencesManager;
import com.demo.menuapp.data.impl.LoginRepositoryImpl;
import com.demo.menuapp.data.model.State;
import com.demo.menuapp.data.model.requestresponse.login.Data;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.login.Token;
import com.demo.menuapp.ui.viewmodel.LoginViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LoginViewModelTest {

    private static final LoginResponse LOGIN_RESPONSE_SUCCESS = new LoginResponse();

    static {
        Data data = new Data();
        Token token = new Token();
        token.setValue("success token value");
        data.setToken(token);
        LOGIN_RESPONSE_SUCCESS.setData(data);
    }

    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    private LoginViewModel loginViewModel;

    private Observer<Void> loginSuccessObserver;
    private Observer<Pair<String, String>> loginErrorObserver;
    private Observer<State> stateObserver;
    private MockPreferencesManager preferencesManager;
    private MockMenuAppApi menuAppApi;

    @Before
    public void setup() {
        preferencesManager = new MockPreferencesManager();
        loginSuccessObserver = mock(Observer.class);
        stateObserver = mock(Observer.class);
        loginErrorObserver = mock(Observer.class);

        menuAppApi = new MockMenuAppApi();

        loginViewModel = new LoginViewModel(new LoginRepositoryImpl(menuAppApi), preferencesManager);

        loginViewModel.getState().observeForever(stateObserver);
        loginViewModel.getLoginSuccess().observeForever(loginSuccessObserver);
        loginViewModel.getLoginError().observeForever(loginErrorObserver);
    }

    @Test
    public void testLoginSuccess() {
        menuAppApi.setLoginResponse(LOGIN_RESPONSE_SUCCESS);

        loginViewModel.login();

        //state changes as following: idle -> busy -> idle, hence idle twice, busy once
        verify(stateObserver, times(2)).onChanged(State.IDLE);
        verify(stateObserver, times(1)).onChanged(State.BUSY);
        //success once
        verify(loginSuccessObserver, times(1)).onChanged(any());

        //never error
        verify(loginErrorObserver, never()).onChanged(any());

        verifyNoMoreInteractions(stateObserver);
        verifyNoMoreInteractions(loginSuccessObserver);
        verifyNoMoreInteractions(loginErrorObserver);

        //finally verify that token was saved
        assertEquals(preferencesManager.getAccessToken(), LOGIN_RESPONSE_SUCCESS.getData().getToken().getValue());
    }

}