package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.LoginHttpParam;
import com.lgy.mvcdemo.net.model.resp.LoginResp;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lgy.mvcdemo.utils.sp.UserSpUtils;

/**
 * Created by ${lgy} on 2018/1/2510:03
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class WelcomeActivity extends BaseActivity {
    LoginHttpParam loginHttpParam;

    @Override
    public int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        super.initView();
        loginHttpParam = new LoginHttpParam();
    }

    @Override
    public void initData() {
        super.initData();
        String userName = UserSpUtils.getUserName();
        String userPassword = UserSpUtils.getUserPassword();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPassword)) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else {
            loginHttpParam.LoginName = userName;
            loginHttpParam.LoginPwd = userPassword;
            httpManger.doPostHttp(loginHttpParam);
        }
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == loginHttpParam.getCommand()) {
            LoginResp loginResp = FastJsonUtil.getObject(result, LoginResp.class);
            UserSpUtils.setUserId(loginResp.getUserId());
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onFail(int command, String errorMsg) {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
