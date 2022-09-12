package com.demo.menuapp.di;

import com.demo.menuapp.data.LoginRepository;
import com.demo.menuapp.data.impl.LoginRepositoryImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class LoginRepositoryModule {
    @Binds
    public abstract LoginRepository bindLoginRepository(LoginRepositoryImpl loginRepositoryImpl);

}
