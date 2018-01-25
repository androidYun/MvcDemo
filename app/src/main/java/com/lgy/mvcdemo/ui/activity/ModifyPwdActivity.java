package com.lgy.mvcdemo.ui.activity;

import android.widget.EditText;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.ModifyPwdHttpParam;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/24.
 */

public class ModifyPwdActivity extends BaseActivity {

    @BindView(R.id.ev_old_pwd)
    EditText evOldPwd;
    @BindView(R.id.ev_new_pwd)
    EditText evNewPwd;
    @BindView(R.id.ev_again_new_pwd)
    EditText evAgainNewPwd;
    private ModifyPwdHttpParam modifyPwdHttpParam;


    @Override
    public int getContentViewId() {
        return R.layout.activity_modify_pwd;
    }

    @Override
    public void initData() {
        super.initData();
        modifyPwdHttpParam = new ModifyPwdHttpParam();
    }


    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        modifyPwdHttpParam.oldPass = evOldPwd.getText().toString().trim();
        modifyPwdHttpParam.newPass = evNewPwd.getText().toString().trim();
        modifyPwdHttpParam.againNewPass = evAgainNewPwd.getText().toString().trim();
        httpManger.doPostHttp(modifyPwdHttpParam);
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        finish();
    }
}
