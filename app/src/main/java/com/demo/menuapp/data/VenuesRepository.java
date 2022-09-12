package com.demo.menuapp.data;

import android.location.Location;

import androidx.lifecycle.MutableLiveData;

import com.demo.menuapp.data.model.RepositoryResult;
import com.demo.menuapp.data.model.State;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.venues.VenuesResponse;

public interface VenuesRepository {
    void getVenues(Location location, MutableLiveData<State> state,
                   MutableLiveData<RepositoryResult<VenuesResponse>> result);
}
