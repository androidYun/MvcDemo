package com.lgy.mvcdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.lgy.mvcdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/24.
 */

public class CompanyDetailActivity extends BaseActivity {
    @BindView(R.id.rv_notice)
    RecyclerView rvNotice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);
        ButterKnife.bind(this);
    }

    @Override
    public int getContentViewId() {
        return 0;
    }
}
