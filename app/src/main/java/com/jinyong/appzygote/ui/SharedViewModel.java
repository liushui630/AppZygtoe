package com.jinyong.appzygote.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public
/**
 * @author jinyong.zheng
 * @date 2021/7/7
 */
class SharedViewModel extends ViewModel {
    public final  MutableLiveData<String>  message = new MutableLiveData<>();
    public final MutableLiveData<String> twoActivityForResult = new MutableLiveData<>();
}
