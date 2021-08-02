package com.jinyong.appzygote.ui.page;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.jinyong.appzygote.BR;
import com.jinyong.appzygote.R;
import com.jinyong.appzygote.ui.SharedViewModel;
import com.jinyong.appzygote.ui.state.TwoActivityViewModel;
import com.jinyong.base.config.DataBindingConfig;
import com.jinyong.base.ui.page.BaseActivity;


public
/**
 * @author jinyong.zheng
 * @date 2021/7/7
 */
class TwoActivity extends BaseActivity {
    private TwoActivityViewModel mState;
    private SharedViewModel mEvent;

    @Override
    protected void initViewModel() {
        mState = getActivityScopeViewModel(TwoActivityViewModel.class);
        mEvent = getApplicationScopeViewModel(SharedViewModel.class);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_two, BR.vm, mState)
                .addBindingParam(BR.click, new ClockProxy());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mState.mText.setValue("这是TwoActivity");
        mEvent.message.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                showShortToast(s);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //mEvent.twoActivityForResult.setValue("测试延迟显示 back");
    }

    public class ClockProxy {
        public void onClick() {
            mEvent.twoActivityForResult.setValue("测试延迟显示 click");
        }
    }
}
