package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.LoginHttpParam;
import com.lgy.mvcdemo.net.model.resp.LoginResp;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.utils.sp.UserSpUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ${lgy} on 2018/1/2416:59
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.ev_account)
    EditText evAccount;
    @BindView(R.id.ev_pwd)
    EditText evPwd;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;

    LoginHttpParam loginHttpParam;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public void initData() {
        super.initData();
        evAccount.setText(UserSpUtils.getUserName());
        evPwd.setText(UserSpUtils.getUserPassword());
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        loginHttpParam = new LoginHttpParam();
        loginHttpParam.LoginName = "admin";
        loginHttpParam.LoginPwd = "123456";
        httpManger.doPostHttp(loginHttpParam);
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == loginHttpParam.getCommand()) {
            LoginResp loginResp = FastJsonUtil.getObject(result, LoginResp.class);
            UserSpUtils.setUserId(loginResp.getUserId());
            UserSpUtils.setUserBean(loginResp);
            UserSpUtils.setUserName(evAccount.getText().toString().trim());
            UserSpUtils.setUserPassword(evPwd.getText().toString().trim());
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

}
