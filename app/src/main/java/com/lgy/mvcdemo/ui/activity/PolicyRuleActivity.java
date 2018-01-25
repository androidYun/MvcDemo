package com.lgy.mvcdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lgy.mvcdemo.R;

/**
 * Created by Administrator on 2018/1/24.
 */

public class PolicyRuleActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poilcy_rule);
    }

    @Override
    public int getContentViewId() {
        return 0;
    }
}
