package com.demo.menuapp.ui.viewmodel;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.demo.menuapp.network.NetworkAvailabilityCallback;
import com.demo.menuapp.network.NetworkAvailabilityProvider;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class InternetConnectionViewModel extends ViewModel {

    private final MutableLiveData<Boolean> internetConnectionAvailable = new MutableLiveData<>(false);
    private final LiveData<Boolean> noInternetConnectionVisible
            = Transformations.map(internetConnectionAvailable, input -> !input);

    private final MutableLiveData<Boolean> forceHideNoInternetBanner = new MutableLiveData<>();

    @Inject
    public InternetConnectionViewModel(NetworkAvailabilityProvider networkAvailabilityProvider) {
        networkAvailabilityProvider.registerNetworkAvailabilityCallback(available -> {
            internetConnectionAvailable.postValue(networkAvailabilityProvider.isNetworkAvailable());
            forceHideNoInternetBanner.postValue(false);
        });
        internetConnectionAvailable.postValue(networkAvailabilityProvider.isNetworkAvailable());
    }

    public MutableLiveData<Boolean> getInternetConnectionAvailable() {
        return internetConnectionAvailable;
    }

    public LiveData<Boolean> getNoInternetConnectionVisible() {
        return noInternetConnectionVisible;
    }

    public MutableLiveData<Boolean> getForceHideNoInternetBanner() {
        return forceHideNoInternetBanner;
    }

    public void dismissNoInternetBanner() {
        forceHideNoInternetBanner.postValue(true);
    }
}
