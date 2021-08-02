package com.jinyong.appzygote.ui.page;

import androidx.lifecycle.ViewModelProvider;

import com.jinyong.appzygote.R;
import com.jinyong.appzygote.ui.state.DashboardViewModel;
import com.jinyong.base.config.DataBindingConfig;
import com.jinyong.base.ui.page.BaseFragment;
import com.kunminx.binding_recyclerview.BR;

public class DashboardFragment extends BaseFragment {

    private DashboardViewModel mState;

    @Override
    protected void initViewModel() {
        mState = new ViewModelProvider(this).get(DashboardViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_dashboard, BR.vm, mState);
    }
}