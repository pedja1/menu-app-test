package com.demo.menuapp.mock;

import com.demo.menuapp.utils.PreferencesManager;

public class MockPreferencesManager implements PreferencesManager {

    private String accessToken;

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public void saveAccessToken(String value) {
        accessToken = value;
    }
}
