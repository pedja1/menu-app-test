package com.demo.menuapp.data;

import androidx.lifecycle.MutableLiveData;

import com.demo.menuapp.data.model.RepositoryResult;
import com.demo.menuapp.data.model.State;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;

public interface LoginRepository {
    void login(String username, String password, MutableLiveData<State> state,
               MutableLiveData<RepositoryResult<LoginResponse>> result);
}
