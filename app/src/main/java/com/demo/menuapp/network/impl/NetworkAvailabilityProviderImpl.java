package com.demo.menuapp.network.impl;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

import androidx.annotation.NonNull;

import com.demo.menuapp.network.NetworkAvailabilityCallback;
import com.demo.menuapp.network.NetworkAvailabilityProvider;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

public class NetworkAvailabilityProviderImpl implements NetworkAvailabilityProvider {

    private final ConnectivityManager connectivityManager;
    private final Set<NetworkAvailabilityCallback> callbacks = new HashSet<>();

    @Inject
    public NetworkAvailabilityProviderImpl(Application application) {
        connectivityManager = application.getSystemService(ConnectivityManager.class);
        NetworkRequest networkRequest = new NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .build();

        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                notifyCallbacks();
            }

            @Override
            public void onLost(@NonNull Network network) {
                notifyCallbacks();
            }
        };
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback);
    }

    @Override
    public void registerNetworkAvailabilityCallback(NetworkAvailabilityCallback callback) {
        callbacks.add(callback);
        callback.onNetworkAvailabilityChanged(isNetworkAvailable());
    }

    @Override
    public void unregisterNetworkAvailabilityCallback(NetworkAvailabilityCallback callback) {
        callbacks.remove(callback);
        callback.onNetworkAvailabilityChanged(isNetworkAvailable());
    }

    @Override
    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void notifyCallbacks() {
        for (NetworkAvailabilityCallback callback : callbacks) {
            callback.onNetworkAvailabilityChanged(isNetworkAvailable());
        }
    }
}
