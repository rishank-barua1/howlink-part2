package com.example.howlinkpart3.ui.signinworkflow.profileSetup;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;

public class ProfileSetupViewModel extends AndroidViewModel {
    private ProfileSetupRepository repository;
    public ProfileSetupViewModel(@NonNull Application application, String pincode) {
        super(application);
        repository = new ProfileSetupRepository(pincode,application);
    }

    public ArrayList<String> getData()
    {
        return repository.getData();
    }
}
