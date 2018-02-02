package com.lgy.mvcdemo.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lgy.mvcdemo.listener.HttpListener;
import com.lgy.mvcdemo.net.utils.HttpManger;
import com.lgy.mvcdemo.utils.ToastUtil;
import com.yanzhenjie.permission.AndPermission;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/19.
 */

public abstract class BaseActivity extends AutoLayoutActivity implements HttpListener {
    public final static int CAMER_CODE = 1000;

    public final static int SCAN_QR_CODE = 1001;//扫描二维码
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

    public void applyForpermission(int code) {
        List<String> permissionArr = new ArrayList<>();
        switch (code) {
            case CAMER_CODE:
                permissionArr.add(Manifest.permission.CAMERA);
                permissionArr.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                permissionArr.add(Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case SCAN_QR_CODE:
                permissionArr.add(Manifest.permission.CAMERA);
                permissionArr.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                permissionArr.add(Manifest.permission.READ_EXTERNAL_STORAGE);
                permissionArr.add(Manifest.permission.VIBRATE);
                break;
        }
        if (AndPermission.hasAlwaysDeniedPermission(this, permissionArr)) {
            // 执行操作。
            onPermissionSuccess(code);
        } else {
            // 提醒用户手机问题，请用户去Setting中授权。这里可以使用AndPermission的SettingDialog。
            onPermissionFail(code);
            AndPermission.defaultSettingDialog(this);
        }
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

    protected void onPermissionSuccess(int code) {

    }

    protected void onPermissionFail(int code) {

    }
}
