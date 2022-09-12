package com.demo.menuapp.network;

public interface NetworkAvailabilityProvider {
    void registerNetworkAvailabilityCallback(NetworkAvailabilityCallback callback);
    void unregisterNetworkAvailabilityCallback(NetworkAvailabilityCallback callback);
    boolean isNetworkAvailable();
}
