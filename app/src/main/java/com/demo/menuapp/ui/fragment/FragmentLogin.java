package com.demo.menuapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.demo.menuapp.R;
import com.demo.menuapp.databinding.FragmentLoginBinding;
import com.demo.menuapp.ui.viewmodel.InternetConnectionViewModel;
import com.demo.menuapp.ui.viewmodel.LoginViewModel;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentLogin extends Fragment {

    private LoginViewModel loginViewModel;
    private InternetConnectionViewModel internetConnectionViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        internetConnectionViewModel = new ViewModelProvider(requireActivity()).get(InternetConnectionViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setLoginViewModel(loginViewModel);
        binding.setInternetConnectionViewModel(internetConnectionViewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        loginViewModel.getLoginSuccess().observe(getViewLifecycleOwner(),
                success -> NavHostFragment.findNavController(this).navigate(FragmentLoginDirections.actionFragmentLoginToFragmentVenues()));
        loginViewModel.getLoginError().observe(getViewLifecycleOwner(),
                error -> showErrorMessage(error.first, error.second));
    }

    private void showErrorMessage(String title, String message) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
        if (title != null) {
            builder.setTitle(title);
        }
        builder.setMessage(message);
        builder.setPositiveButton(R.string.dialog_error_close, null);
        builder.show();
    }
}
