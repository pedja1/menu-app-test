package com.demo.menuapp.ui.viewmodel;

import android.util.Pair;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.demo.menuapp.data.LoginRepository;
import com.demo.menuapp.data.model.RepositoryResult;
import com.demo.menuapp.data.model.State;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.utils.PreferencesManager;
import com.demo.menuapp.utils.SingleLiveEvent;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends ViewModel {

    private final MutableLiveData<State> state = new MutableLiveData<>(State.IDLE);
    private final MutableLiveData<RepositoryResult<LoginResponse>> loginResponse = new SingleLiveEvent<>();

    private final MediatorLiveData<Void> loginSuccess = new MediatorLiveData<>();
    private final MutableLiveData<Void> logoutSuccess = new SingleLiveEvent<>();
    private final MediatorLiveData<Pair<String, String>> loginError = new MediatorLiveData<>();

    public final MutableLiveData<String> username = new MutableLiveData<>();
    public final MutableLiveData<String> password = new MutableLiveData<>();

    private final LoginRepository loginRepository;
    private final PreferencesManager preferencesManager;

    @Inject
    public LoginViewModel(LoginRepository loginRepository, PreferencesManager preferencesManager) {
        this.loginRepository = loginRepository;
        this.preferencesManager = preferencesManager;

        loginSuccess.addSource(loginResponse, loginResponseRepositoryResult -> {
            LoginResponse loginResponse = loginResponseRepositoryResult.getData();
            if (loginResponse != null && loginResponse.getData() != null && loginResponse.getData().getToken() != null && loginResponse.getData().getToken().getValue() != null) {
                preferencesManager.saveAccessToken(loginResponse.getData().getToken().getValue());
                loginSuccess.postValue(null);
            }
        });
        loginError.addSource(loginResponse, loginResponseRepositoryResult -> {
            if (loginResponseRepositoryResult.getData() == null) {
                loginError.postValue(new Pair<>(null, loginResponseRepositoryResult.getError()));
            } else if (loginResponseRepositoryResult.getData() != null && loginResponseRepositoryResult.getData().getData() != null
                    && loginResponseRepositoryResult.getData().getData().getInfoMessage() != null) {
                loginError.postValue(new Pair<>(loginResponseRepositoryResult.getData().getData().getInfoMessage().getTitle(),
                        loginResponseRepositoryResult.getData().getData().getInfoMessage().getBody()));
            }
        });
    }

    public void login() {
        //TODO input validation
        loginRepository.login(username.getValue(), password.getValue(), state, loginResponse);
    }

    public void logout() {
        preferencesManager.saveAccessToken(null);
        logoutSuccess.postValue(null);
    }

    public LiveData<State> getState() {
        return state;
    }

    public LiveData<Pair<String, String>> getLoginError() {
        return loginError;
    }

    public LiveData<Void> getLoginSuccess() {
        return loginSuccess;
    }

    public LiveData<Void> getLogoutSuccess() {
        return logoutSuccess;
    }
}
