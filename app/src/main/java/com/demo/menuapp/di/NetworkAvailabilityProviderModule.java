package com.demo.menuapp.di;

import com.demo.menuapp.network.NetworkAvailabilityProvider;
import com.demo.menuapp.network.impl.NetworkAvailabilityProviderImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class NetworkAvailabilityProviderModule {
    @Binds
    public abstract NetworkAvailabilityProvider bindNetworkAvailabilityProvider(NetworkAvailabilityProviderImpl networkAvailabilityProviderImpl);

}
