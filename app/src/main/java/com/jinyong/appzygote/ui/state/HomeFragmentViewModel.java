package com.jinyong.appzygote.ui.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeFragmentViewModel extends ViewModel {
    public final MutableLiveData<String> mText = new MutableLiveData<>();
}