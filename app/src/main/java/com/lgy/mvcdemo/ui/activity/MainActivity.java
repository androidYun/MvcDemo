package com.lgy.mvcdemo.ui.activity;

import android.os.Bundle;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.LoginHttpParam;
import com.lgy.mvcdemo.utils.ToastUtil;

public class MainActivity extends BaseActivity {
    LoginHttpParam loginHttpParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginHttpParam = new LoginHttpParam();
        loginHttpParam.LoginName = "admin";
        loginHttpParam.LoginPwd = "123456";
        httpManger.doPostHttp(loginHttpParam);
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == loginHttpParam.getCommand()) {
            ToastUtil.show(this, "请求成功了啊");
        }
    }
}
