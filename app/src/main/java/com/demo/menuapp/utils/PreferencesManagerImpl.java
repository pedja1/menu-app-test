package com.demo.menuapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class PreferencesManagerImpl implements PreferencesManager {

    private static final String KEY_ACCESS_TOKEN = "access_token";

    private final SharedPreferences sharedPreferences;

    public PreferencesManagerImpl(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public String getAccessToken() {
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void saveAccessToken(String value) {
        sharedPreferences.edit().putString(KEY_ACCESS_TOKEN, value).apply();
    }
}
