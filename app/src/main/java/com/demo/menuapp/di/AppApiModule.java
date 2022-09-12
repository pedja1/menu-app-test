package com.demo.menuapp.di;

import com.demo.menuapp.network.MenuAppApi;
import com.demo.menuapp.network.impl.MenuAppApiImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppApiModule {
    @Binds
    public abstract MenuAppApi bindMenuAppAPi(MenuAppApiImpl menuAppApi);
}
