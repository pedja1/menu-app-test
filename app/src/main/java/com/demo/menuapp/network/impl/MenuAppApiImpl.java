package com.demo.menuapp.network.impl;

import android.location.Location;

import androidx.annotation.NonNull;

import com.demo.menuapp.data.model.requestresponse.login.LoginRequest;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesRequest;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesResponse;
import com.demo.menuapp.network.ApiCallback;
import com.demo.menuapp.network.ApiClient;
import com.demo.menuapp.network.MenuAppApi;
import com.demo.menuapp.network.MenuAppService;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class MenuAppApiImpl implements MenuAppApi {

    private final MenuAppService menuAppService;
    private final ApiClient apiClient;

    @Inject
    public MenuAppApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
        menuAppService = apiClient.createService(MenuAppService.class);
    }

    @Override
    public void login(String username, String password, ApiCallback<LoginResponse> callback) {
        menuAppService.login(new LoginRequest(username, password)).enqueue(handleResponse(callback));
    }

    @Override
    public void getVenues(Location location, ApiCallback<VenuesResponse> callback) {
        menuAppService.getVenues(new VenuesRequest(location.getLatitude(), location.getLongitude())).enqueue(handleResponse(callback));
    }

    private <T> Callback<T> handleResponse(ApiCallback<T> callback) {
        return new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if(response.body() != null) {
                    callback.onSuccess(response.body());
                } else if(response.errorBody() != null) {
                    Converter<ResponseBody, LoginResponse> converter =
                            apiClient.responseBodyConverter(LoginResponse.class, new Annotation[0]);
                    try {
                        callback.onSuccess((T) converter.convert(response.errorBody()));
                    } catch (IOException e) {
                        onFailure(call, e);
                    }
                } else {
                    onFailure(call, new Exception("Unknown error"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                callback.onError(t);
            }
        };
    }
}
