package com.example.basededatos2025.ui.agregar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AgregarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AgregarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is agregar fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}