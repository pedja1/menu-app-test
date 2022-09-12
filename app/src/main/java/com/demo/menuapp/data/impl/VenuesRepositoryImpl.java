package com.demo.menuapp.data.impl;

import android.location.Location;

import androidx.lifecycle.MutableLiveData;

import com.demo.menuapp.data.LoginRepository;
import com.demo.menuapp.data.VenuesRepository;
import com.demo.menuapp.data.model.RepositoryResult;
import com.demo.menuapp.data.model.State;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesResponse;
import com.demo.menuapp.network.ApiCallback;
import com.demo.menuapp.network.MenuAppApi;

import javax.inject.Inject;

public class VenuesRepositoryImpl implements VenuesRepository {

    private final MenuAppApi api;

    @Inject
    VenuesRepositoryImpl(MenuAppApi api) {
        this.api = api;
    }

    @Override
    public void getVenues(Location location, MutableLiveData<State> state,
                          MutableLiveData<RepositoryResult<VenuesResponse>> result) {
        state.postValue(State.BUSY);
        api.getVenues(location, new ApiCallback<VenuesResponse>() {

            @Override
            public void onSuccess(VenuesResponse body) {
                state.postValue(State.IDLE);
                result.postValue(new RepositoryResult<>(body));
            }

            @Override
            public void onError(Throwable t) {
                state.postValue(State.IDLE);
                result.postValue(new RepositoryResult<>(t.getMessage()));
            }
        });
    }
}
