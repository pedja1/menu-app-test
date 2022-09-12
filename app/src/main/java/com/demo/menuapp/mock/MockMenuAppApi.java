package com.demo.menuapp.mock;

import android.location.Location;

import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesResponse;
import com.demo.menuapp.network.ApiCallback;
import com.demo.menuapp.network.MenuAppApi;

public class MockMenuAppApi implements MenuAppApi {

    private LoginResponse loginResponse;
    private Throwable loginError;
    private VenuesResponse venuesResponse;
    private Throwable venuesError;

    @Override
    public void login(String username, String password, ApiCallback<LoginResponse> callback) {
        if(loginResponse != null) {
            callback.onSuccess(loginResponse);
        } else if(loginError != null) {
            callback.onError(loginError);
        }
    }

    @Override
    public void getVenues(Location location, ApiCallback<VenuesResponse> callback) {
        if(venuesResponse != null) {
            callback.onSuccess(venuesResponse);
        } else if(venuesError != null) {
            callback.onError(venuesError);
        }
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
        this.loginError = null;
    }

    public void setVenuesResponse(VenuesResponse venuesResponse) {
        this.venuesResponse = venuesResponse;
        this.venuesError = null;
    }

    public void setLoginError(Throwable loginError) {
        this.loginError = loginError;
        this.loginResponse = null;
    }

    public void setVenuesError(Throwable venuesError) {
        this.venuesError = venuesError;
        this.venuesResponse = null;
    }
}
