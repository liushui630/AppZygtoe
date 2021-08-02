package com.jinyong.appzygote.ui.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * @author jinyong.zheng
 * @date 2021/7/6
 */
public class MainActivityViewModel extends ViewModel {
    public final MutableLiveData<List<String>> tabList = new MutableLiveData<>();
}
