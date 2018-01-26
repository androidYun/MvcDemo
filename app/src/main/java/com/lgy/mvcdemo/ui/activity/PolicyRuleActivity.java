package com.lgy.mvcdemo.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.LowRuleHttpParam;
import com.lgy.mvcdemo.net.model.resp.LowRuleResp;
import com.lgy.mvcdemo.ui.adapter.PolicyRuleAdapter;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.view.NaviTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/24.
 */

public class PolicyRuleActivity extends BaseActivity {

    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.rv_rule)
    RecyclerView rvRule;
    private LowRuleHttpParam lowRuleHttpParam;

    private PolicyRuleAdapter policyRuleAdapter;

    private List<LowRuleResp.PolicyListBean> mDataList = new ArrayList<>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_poilcy_rule;
    }

    @Override
    protected void initView() {
        super.initView();
        rvRule.setLayoutManager(new LinearLayoutManager(this));
        policyRuleAdapter = new PolicyRuleAdapter(this, R.layout.item_policy_layout, mDataList);
        rvRule.setAdapter(policyRuleAdapter);
        lowRuleHttpParam = new LowRuleHttpParam();
        httpManger.doPostHttp(lowRuleHttpParam);
    }
    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == lowRuleHttpParam.getCommand()) {
            LowRuleResp lowRuleResp = FastJsonUtil.getObject(result, LowRuleResp.class);
            if (lowRuleResp.getPolicyList() != null && lowRuleResp.getPolicyList().size() > 0) {
                mDataList.clear();
                mDataList.addAll(lowRuleResp.getPolicyList());
                policyRuleAdapter.notifyDataSetChanged();
            }
        }
    }

}
