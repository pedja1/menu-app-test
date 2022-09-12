package com.demo.menuapp.network;

import android.location.Location;

import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesResponse;

import retrofit2.Callback;

public interface MenuAppApi {
    void login(String username, String password, ApiCallback<LoginResponse> callback);

    void getVenues(Location location, ApiCallback<VenuesResponse> callback);
}
