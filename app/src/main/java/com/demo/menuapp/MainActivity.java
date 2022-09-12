package com.demo.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.demo.menuapp.databinding.ActivityMainBinding;
import com.demo.menuapp.ui.viewmodel.InternetConnectionViewModel;
import com.demo.menuapp.ui.viewmodel.VenuesViewModel;
import com.demo.menuapp.utils.PreferencesManager;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InternetConnectionViewModel internetConnectionViewModel = new ViewModelProvider(this).get(InternetConnectionViewModel.class);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setViewModel(internetConnectionViewModel);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        NavInflater inflater = navController.getNavInflater();
        NavGraph navGraph = inflater.inflate(R.navigation.navigation);


        if(preferencesManager.getAccessToken() == null) {
            navGraph.setStartDestination(R.id.fragmentLogin);
        } else {
            navGraph.setStartDestination(R.id.fragmentVenues);
        }
        navController.setGraph(navGraph);
    }
}