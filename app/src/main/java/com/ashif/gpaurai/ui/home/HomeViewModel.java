package com.ashif.gpaurai.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("_Welcome_\n_Government Polytechnic Aurai_");
    }

    public LiveData<String> getText() {
        return mText;
    }
}