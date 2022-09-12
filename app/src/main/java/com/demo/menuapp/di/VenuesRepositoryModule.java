package com.demo.menuapp.di;

import com.demo.menuapp.data.VenuesRepository;
import com.demo.menuapp.data.impl.VenuesRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class VenuesRepositoryModule {
    @Binds
    public abstract VenuesRepository bindLoginRepository(VenuesRepositoryImpl venuesRepositoryImpl);

}
