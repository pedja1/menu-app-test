package com.demo.menuapp.data.impl;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;

import com.demo.menuapp.data.LoginRepository;
import com.demo.menuapp.data.model.RepositoryResult;
import com.demo.menuapp.data.model.State;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.network.ApiCallback;
import com.demo.menuapp.network.MenuAppApi;

import javax.inject.Inject;

public class LoginRepositoryImpl implements LoginRepository {

    private final MenuAppApi api;

    @Inject
    public LoginRepositoryImpl(MenuAppApi api) {
        this.api = api;
    }

    @Override
    public void login(String username, String password, MutableLiveData<State> state,
                      MutableLiveData<RepositoryResult<LoginResponse>> result) {
        state.postValue(State.BUSY);
        api.login(username, password, new ApiCallback<LoginResponse>() {

            @Override
            public void onSuccess(LoginResponse body) {
                state.postValue(State.IDLE);
                result.postValue(new RepositoryResult<>(body));
            }

            @Override
            public void onError(Throwable t) {
                state.postValue(State.IDLE);
                result.postValue(new RepositoryResult<>(t.getMessage()));
            }
        });
    }
}
