package com.demo.menuapp.network.impl;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MenuAppInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Content-Type", "application/json");
        builder.addHeader("application", "mobile-application");
        builder.addHeader("Device-UUID", "12345");//TODO UUID.randomUUID() when app first starts and save to shared prefs, then read from prefs here
        builder.addHeader("Api-Version", "3.7.0");//TODO put in BuildConfig maybe
        return chain.proceed(builder.build());
    }
}
