package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.model.resp.LoginResp;
import com.lgy.mvcdemo.utils.sp.UserSpUtils;
import com.lgy.mvcdemo.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SetActivity extends BaseActivity {


    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_type)
    TextView tvType;

    @Override
    public int getContentViewId() {
        return R.layout.activity_set;
    }

    @Override
    public void initData() {
        super.initData();
        LoginResp userBean = UserSpUtils.getUserBean();
        tvName.setText(UserSpUtils.getUserName());
    }

    @OnClick({R.id.rl_modify_pwd, R.id.rl_modify_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_modify_pwd:
                startActivity(new Intent(this, ModifyPwdActivity.class));
                break;
            case R.id.rl_modify_head:
                break;
        }
    }


}
