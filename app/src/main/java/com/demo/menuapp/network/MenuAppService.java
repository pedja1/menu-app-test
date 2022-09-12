package com.demo.menuapp.network;

import com.demo.menuapp.data.model.requestresponse.login.LoginRequest;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesRequest;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MenuAppService {
    @POST("api/customers/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("api/directory/search")
    Call<VenuesResponse> getVenues(@Body VenuesRequest request);
}
