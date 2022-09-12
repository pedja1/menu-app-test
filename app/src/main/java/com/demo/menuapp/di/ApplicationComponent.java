package com.demo.menuapp.di;

import com.demo.menuapp.ui.fragment.FragmentLogin;
import com.demo.menuapp.ui.fragment.FragmentVenues;

import dagger.Component;

@Component
public interface ApplicationComponent {
    void inject(FragmentLogin fragmentLogin);
    void inject(FragmentVenues fragmentVenues);
}