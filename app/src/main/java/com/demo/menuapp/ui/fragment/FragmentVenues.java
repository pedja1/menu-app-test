package com.demo.menuapp.ui.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.demo.menuapp.R;
import com.demo.menuapp.databinding.FragmentVenuesBinding;
import com.demo.menuapp.ui.adapter.VenuesAdapter;
import com.demo.menuapp.ui.viewmodel.VenuesViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentVenues extends Fragment {

    private VenuesViewModel venuesViewModel;

    private VenuesAdapter venuesAdapter;

    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    requestLocationUpdates();
                } else {
                    showNoPermissionDialog();
                }
            });

    private final LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(@NonNull LocationResult locationResult) {
            if (locationResult.getLastLocation() != null) {
                venuesViewModel.onLocationChanged(locationResult.getLastLocation());
            }
        }
    };
    private FusedLocationProviderClient fusedLocationProviderClient;

    private final LocationRequest locationRequest = LocationRequest.create();//default should be good enough

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        venuesViewModel = new ViewModelProvider(this).get(VenuesViewModel.class);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext());
        venuesAdapter = new VenuesAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentVenuesBinding binding = FragmentVenuesBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setVenuesViewModel(venuesViewModel);
        binding.setVenuesAdapter(venuesAdapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        venuesAdapter.setOnItemClickListener(item -> {
            NavHostFragment.findNavController(this)
                    .navigate(FragmentVenuesDirections.actionFragmentVenuesToFragmentVenue(item));
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        requestLocationUpdates();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopLocationUpdates();
    }

    private void requestLocationUpdates() {
        if (ContextCompat.checkSelfPermission(
                requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                    locationCallback,
                    Looper.getMainLooper());
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION);
        }

    }

    private void stopLocationUpdates() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
    }

    private void showNoPermissionDialog() {
        new MaterialAlertDialogBuilder(requireContext())
                .setMessage(R.string.dialog_error_no_permission_message)
                .setPositiveButton(R.string.dialog_error_close, null)
                .show();
    }

}
