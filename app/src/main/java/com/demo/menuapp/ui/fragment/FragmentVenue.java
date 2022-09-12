package com.demo.menuapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.demo.menuapp.databinding.FragmentVenueBinding;
import com.demo.menuapp.ui.view.VenueViewItem;
import com.demo.menuapp.ui.viewmodel.LoginViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentVenue extends Fragment {

    private VenueViewItem venue;

    private LoginViewModel loginViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        venue = FragmentVenueArgs.fromBundle(requireArguments()).getVenue();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentVenueBinding binding = FragmentVenueBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setVenue(venue);
        binding.setViewModel(loginViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        loginViewModel.getLogoutSuccess().observe(getViewLifecycleOwner(), unused -> NavHostFragment.findNavController(this)
                .navigate(FragmentVenueDirections.actionFragmentVenueToFragmentLogin()));
    }
}
