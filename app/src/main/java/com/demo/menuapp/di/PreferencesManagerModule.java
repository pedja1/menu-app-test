package com.demo.menuapp.di;

import android.content.Context;

import com.demo.menuapp.BuildConfig;
import com.demo.menuapp.network.impl.ApiClientImpl;
import com.demo.menuapp.utils.PreferencesManager;
import com.demo.menuapp.utils.PreferencesManagerImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class PreferencesManagerModule {
    @Binds
    public abstract PreferencesManager bindPreferencesManager(PreferencesManagerImpl preferencesManager);

    @Provides
    public static PreferencesManagerImpl providePreferencesManagerImpl(@ApplicationContext Context context) {
        return new PreferencesManagerImpl(context);
    }
}
