package com.lgy.mvcdemo.ui.activity;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lgy.mvcdemo.listener.HttpListener;
import com.lgy.mvcdemo.net.utils.HttpManger;
import com.lgy.mvcdemo.utils.ToastUtil;
import com.yanzhenjie.permission.AndPermission;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import me.bakumon.statuslayoutmanager.library.OnStatusChildClickListener;
import me.bakumon.statuslayoutmanager.library.StatusLayoutManager;

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

    public StatusLayoutManager getStatusLayoutManager(View view, int emptyId) {
        StatusLayoutManager statusLayoutManager = new StatusLayoutManager.Builder(view).setOnStatusChildClickListener(new OnStatusChildClickListener() {
            @Override
            public void onEmptyChildClick(View view) {
                emptyViewClick();
            }

            @Override
            public void onErrorChildClick(View view) {

            }

            @Override
            public void onCustomerChildClick(View view) {

            }
        })
                // 设置默认加载中布局的提示文本
                .setDefaultLoadingText("正在加载...")

                // 设置默认空数据布局的提示文本
                .setDefaultEmptyText("暂时没有数据")
                // 设置默认空数据布局的图片
                .setDefaultEmptyImg(emptyId)
                // 设置默认出错布局的提示文本
                .setDefaultErrorText("加载数据失败")
                // 设置默认出错布局的图片
                .setDefaultErrorImg(emptyId)
                // 设置默认出错布局重试按钮的文本
                // 设置布局背景，包括加载中、空数据和出错布局
                .setDefaultLayoutsBackgroundColor(Color.WHITE)
                .build();
        return statusLayoutManager;
    }

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

    protected void emptyViewClick() {

    }
}
