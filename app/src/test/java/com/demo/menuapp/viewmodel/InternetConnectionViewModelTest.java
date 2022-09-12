package com.demo.menuapp.viewmodel;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.demo.menuapp.network.NetworkAvailabilityCallback;
import com.demo.menuapp.network.NetworkAvailabilityProvider;
import com.demo.menuapp.ui.viewmodel.InternetConnectionViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class InternetConnectionViewModelTest {

    @Rule
    public InstantTaskExecutorRule executorRule = new InstantTaskExecutorRule();

    private InternetConnectionViewModel viewModel;
    private SimpleNetworkAvailabilityProvider networkAvailabilityProvider;
    private Observer<Boolean> internetConnectionAvailableObserver;
    private Observer<Boolean> noInternetConnectionVisibleObserver;
    private Observer<Boolean> forceHideNoInternetBannerObserver;

    @Before
    public void setup() {
        networkAvailabilityProvider = new SimpleNetworkAvailabilityProvider();
        viewModel = new InternetConnectionViewModel(networkAvailabilityProvider);

        internetConnectionAvailableObserver = mock(Observer.class);
        noInternetConnectionVisibleObserver = mock(Observer.class);
        forceHideNoInternetBannerObserver = mock(Observer.class);

        viewModel.getInternetConnectionAvailable().observeForever(internetConnectionAvailableObserver);
        viewModel.getNoInternetConnectionVisible().observeForever(noInternetConnectionVisibleObserver);
        viewModel.getForceHideNoInternetBanner().observeForever(forceHideNoInternetBannerObserver);
    }

    @Test
    public void testThatInternetConnectionAvailableChangesWhenNetworkChanges() {
        networkAvailabilityProvider.setNetworkAvailable(false);
        verify(internetConnectionAvailableObserver, atLeastOnce()).onChanged(false);

        networkAvailabilityProvider.setNetworkAvailable(true);
        verify(internetConnectionAvailableObserver, atLeastOnce()).onChanged(true);
    }

    @Test
    public void testThatForceHideNoInternetBannerResetOnNetworkChange() {
        //initially it should be false
        verify(forceHideNoInternetBannerObserver, atLeastOnce()).onChanged(false);

        //set to true
        viewModel.dismissNoInternetBanner();
        verify(forceHideNoInternetBannerObserver, atLeastOnce()).onChanged(true);

        //false again after network changed
        networkAvailabilityProvider.setNetworkAvailable(true);
        verify(forceHideNoInternetBannerObserver, atLeastOnce()).onChanged(false);

    }

    @Test
    public void testThatNoInternetConnectionVisibleIsTheOppositeOfInternetConnectionAvailable() {

        networkAvailabilityProvider.setNetworkAvailable(false);
        verify(internetConnectionAvailableObserver, atLeastOnce()).onChanged(false);
        verify(noInternetConnectionVisibleObserver, atLeastOnce()).onChanged(true);

        networkAvailabilityProvider.setNetworkAvailable(true);
        verify(internetConnectionAvailableObserver, atLeastOnce()).onChanged(true);
        verify(noInternetConnectionVisibleObserver, atLeastOnce()).onChanged(false);
    }

    private static class SimpleNetworkAvailabilityProvider implements NetworkAvailabilityProvider {

        private boolean networkAvailable = false;
        private final Set<NetworkAvailabilityCallback> callbacks = new HashSet<>();

        @Override
        public void registerNetworkAvailabilityCallback(NetworkAvailabilityCallback callback) {
            callbacks.add(callback);
            callback.onNetworkAvailabilityChanged(networkAvailable);
        }

        @Override
        public void unregisterNetworkAvailabilityCallback(NetworkAvailabilityCallback callback) {
            callbacks.remove(callback);
            callback.onNetworkAvailabilityChanged(networkAvailable);
        }

        @Override
        public boolean isNetworkAvailable() {
            return networkAvailable;
        }

        public void setNetworkAvailable(boolean networkAvailable) {
            this.networkAvailable = networkAvailable;
            for (NetworkAvailabilityCallback callback : callbacks) {
                callback.onNetworkAvailabilityChanged(isNetworkAvailable());
            }
        }
    }
}