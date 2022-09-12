package com.demo.menuapp.di;

import android.content.Context;

import com.demo.menuapp.BuildConfig;
import com.demo.menuapp.network.ApiClient;
import com.demo.menuapp.network.impl.ApiClientImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class ApiClientModule {
    @Binds
    public abstract ApiClient bindApiClient(ApiClientImpl apiClientImpl);

    @Provides
    public static ApiClientImpl provideApiClientImpl(@ApplicationContext Context context) {
        return new ApiClientImpl(context, BuildConfig.BASE_URL);
    }

}
