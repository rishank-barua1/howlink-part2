package com.example.howlinkpart3.ui.signinworkflow.profileSetup;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelProvider implements ViewModelProvider.Factory {
    private Application mApplication;
    private String pincode;
    public MyViewModelProvider(Application application,String pincode)
    {
        this.mApplication = application;

    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProfileSetupViewModel(mApplication, pincode);
    }
}