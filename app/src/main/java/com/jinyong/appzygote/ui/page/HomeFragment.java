package com.jinyong.appzygote.ui.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;


import com.jinyong.appzygote.BR;
import com.jinyong.appzygote.R;
import com.jinyong.appzygote.ui.SharedViewModel;
import com.jinyong.appzygote.ui.state.HomeFragmentViewModel;
import com.jinyong.base.config.DataBindingConfig;
import com.jinyong.base.ui.page.BaseFragment;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends BaseFragment {

    private HomeFragmentViewModel mState;
    private SharedViewModel mEvent;

    @Override
    protected void initViewModel() {
        mState = getFragmentScopeViewModel(HomeFragmentViewModel.class);
        mEvent = getApplicationScopeViewModel(SharedViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_home, BR.vm, mState)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mState.mText.setValue("This is home fragment");

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEvent.twoActivityForResult.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
    }

    public class ClickProxy {
        public void openTwoPage() {
            mEvent.message.setValue("say hello from home fragment");
            Intent intent = new Intent();
            intent.setClass(getActivity(), TwoActivity.class);
            startActivity(intent);
        }
    }
}