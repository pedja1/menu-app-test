package com.demo.menuapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.StyleRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.demo.menuapp.data.model.requestresponse.login.Data;
import com.demo.menuapp.data.model.requestresponse.login.LoginResponse;
import com.demo.menuapp.data.model.requestresponse.login.Token;
import com.demo.menuapp.di.AppApiModule;
import com.demo.menuapp.mock.MockMenuAppApi;
import com.demo.menuapp.network.MenuAppApi;
import com.demo.menuapp.ui.fragment.FragmentLogin;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.function.Function;

import dagger.hilt.android.testing.BindValue;
import dagger.hilt.android.testing.HiltAndroidRule;
import dagger.hilt.android.testing.HiltAndroidTest;
import dagger.hilt.android.testing.UninstallModules;

@RunWith(AndroidJUnit4.class)
@UninstallModules(AppApiModule.class)
@HiltAndroidTest
public class LoginFlowTest {

    private static final String SUCCESS_EMAIL = "test@testmenu.app";
    private static final String SUCCESS_PASSWORD = "test1234";
    private static final LoginResponse LOGIN_RESPONSE_SUCCESS = new LoginResponse();

    static {
        Data data = new Data();
        Token token = new Token();
        token.setValue("success token value");
        data.setToken(token);
        LOGIN_RESPONSE_SUCCESS.setData(data);
    }

    @Rule
    public HiltAndroidRule hiltRule = new HiltAndroidRule(this);

    @BindValue
    MenuAppApi menuAppApi = new MockMenuAppApi();

    private TestNavHostController navHostController;

    @Before
    public void setup() {
        hiltRule.inject();
        navHostController = new TestNavHostController(ApplicationProvider.getApplicationContext());
    }

    @Test
    public void testLoginSuccessFlow() throws InterruptedException {

        ;

        launchFragmentInHiltContainer(new Bundle(), R.style.AppTheme, fragment -> {
            NavInflater inflater = navHostController.getNavInflater();
            NavGraph navGraph = inflater.inflate(R.navigation.navigation);
            navGraph.setStartDestination(R.id.fragmentLogin);
            navHostController.setGraph(navGraph);
            Navigation.setViewNavController(fragment.requireView(), navHostController);
            return null;
        });

        ((MockMenuAppApi) menuAppApi).setLoginResponse(LOGIN_RESPONSE_SUCCESS);
        onView(withId(R.id.editTextEmail)).perform(typeText(SUCCESS_EMAIL));
        onView(withId(R.id.editTextEmail)).perform(typeText(SUCCESS_PASSWORD), closeSoftKeyboard());
        onView(withId(R.id.buttonSignIn)).perform(click());

        Thread.sleep(1000);

        assertEquals(
                navHostController.getCurrentDestination().getId(),
                R.id.fragmentVenues
        );

    }

    //TODO make this more robust, currently launching with hardcoded fragment
    private void launchFragmentInHiltContainer(
            Bundle fragmentArgs,
            @StyleRes int themeResId,
            Function<Fragment, Void> onLaunched) {
        Intent startActivityIntent = Intent.makeMainActivity(
                new ComponentName(ApplicationProvider.getApplicationContext(), HiltTestActivity.class)
        ).putExtra(FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, themeResId);

        ActivityScenario.launch(startActivityIntent).onActivity(activity -> {
            Fragment fragment = new FragmentLogin();
            fragment.setArguments(fragmentArgs);
            ((HiltTestActivity) activity).getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment, "")
                    .commitNow();
            onLaunched.apply(fragment);
        });
    }
}
