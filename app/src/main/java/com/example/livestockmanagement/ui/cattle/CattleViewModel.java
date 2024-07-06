package com.example.livestockmanagement.ui.cattle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CattleViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CattleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}