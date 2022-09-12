package com.demo.menuapp.network.impl;

import android.content.Context;

import com.demo.menuapp.BuildConfig;
import com.demo.menuapp.network.ApiClient;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientImpl implements ApiClient {

    private final Retrofit retrofit;

    @Inject
    public ApiClientImpl(Context context, String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(createHttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient createHttpClient(Context context) {
        long cacheSize = 10 * 1024 * 1024L; // 10 MB

        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        builder.addInterceptor(new MenuAppInterceptor());
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            builder.addInterceptor(interceptor);
            builder.addNetworkInterceptor(interceptor);
        }
        return builder.build();
    }

    @Override
    public <S> S createService(Class<S> clazz) {
        return retrofit.create(clazz);
    }

    @Override
    public <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotations) {
        return retrofit.responseBodyConverter(type, annotations);
    }
}
