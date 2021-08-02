package com.jinyong.appzygote;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jinyong.appzygote.ui.SharedViewModel;
import com.jinyong.appzygote.ui.state.MainActivityViewModel;
import com.jinyong.base.config.DataBindingConfig;
import com.jinyong.base.ui.page.BaseActivity;

/**
 * @author jinyong.zheng
 * @date 2021/7/5
 */
public class MainActivity extends BaseActivity {
    private MainActivityViewModel mState;
    private SharedViewModel mEvent;

    @Override
    protected void initViewModel() {
        mState = getActivityScopeViewModel(MainActivityViewModel.class);
        mEvent = getApplicationScopeViewModel(SharedViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, mState);
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        NavController nav = Navigation.findNavController(this, R.id.main_fragment_host);
        NavigationUI.setupWithNavController((BottomNavigationView) getBinding().getRoot().findViewById(R.id.bottom_navigation), nav);

        mEvent.twoActivityForResult.observe(this, s -> {
            showShortToast(s+", mainActivity");
        });
    }
}
