package com.example.livestockmanagement.ui.milk;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MilkViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MilkViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}