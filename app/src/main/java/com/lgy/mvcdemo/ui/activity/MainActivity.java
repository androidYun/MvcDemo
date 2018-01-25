package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.model.resp.LoginResp;
import com.lgy.mvcdemo.utils.sp.UserSpUtils;
import com.lgy.mvcdemo.view.CircleImageView;
import com.lgy.mvcdemo.view.NaviTitleView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.view_top)
    View viewTop;
    @BindView(R.id.tv_day_add_company)
    TextView tvDayAddCompany;
    @BindView(R.id.tv_week_add_company)
    TextView tvWeekAddCompany;
    @BindView(R.id.tv_month_add_company)
    TextView tvMonthAddCompany;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.tv_rule)
    TextView tvRule;
    @BindView(R.id.tv_add_company)
    TextView tvAddCompany;
    @BindView(R.id.tv_search_company)
    TextView tvSearchCompany;
    @BindView(R.id.tv_build_infor)
    TextView tvBuildInfor;
    @BindView(R.id.tv_set)
    TextView tvSet;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        LoginResp userBean = UserSpUtils.getUserBean();
        tvDayAddCompany.setText(userBean.getDayNum() + "");
        tvWeekAddCompany.setText(userBean.getWeekNum() + "");
        tvMonthAddCompany.setText(userBean.getMonthNum() + "");
    }


    @OnClick({R.id.tv_notice, R.id.tv_rule, R.id.tv_add_company, R.id.tv_search_company, R.id.tv_build_infor, R.id.tv_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_notice:
                startActivity(new Intent(this, NoticeBoardActivity.class));
                break;
            case R.id.tv_rule:
                break;
            case R.id.tv_add_company:
                startActivity(new Intent(this, AddCompanyActivity.class));
                break;
            case R.id.tv_search_company:
                startActivity(new Intent(this, SearchCompanyActivity.class));
                break;
            case R.id.tv_build_infor:
                break;
            case R.id.tv_set:
                startActivity(new Intent(this, SetActivity.class));
                break;
        }
    }
}
