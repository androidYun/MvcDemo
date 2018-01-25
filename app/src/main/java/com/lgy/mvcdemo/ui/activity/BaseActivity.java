package com.lgy.mvcdemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lgy.mvcdemo.listener.HttpListener;
import com.lgy.mvcdemo.net.utils.HttpManger;
import com.lgy.mvcdemo.utils.ToastUtil;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/19.
 */

public abstract class BaseActivity extends AutoLayoutActivity implements HttpListener {
    protected HttpManger httpManger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        httpManger = new HttpManger(this, this);
        int viewId = getContentViewId();
        setContentView(viewId);
        ButterKnife.bind(this);
        initView();
        initData();
        bindEventListener();
    }

    public abstract int getContentViewId();

    protected void initView() {

    }

    public void initData() {
    }

    public void bindEventListener() {
    }

    @Override
    public void onSuccess(int command, String result) {

    }

    @Override
    public void onFail(int command, String errorMsg) {
        ToastUtil.show(this, errorMsg);
    }

    @Override
    public void onLoadingProcess() {

    }

    @Override
    public void onHideProcess() {

    }
}
