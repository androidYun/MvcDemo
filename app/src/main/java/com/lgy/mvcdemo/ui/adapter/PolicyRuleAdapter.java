package com.lgy.mvcdemo.ui.adapter;

import android.content.Context;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.model.resp.LowRuleResp;
import com.lgy.mvcdemo.utils.SpanUtils;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by ${lgy} on 2018/1/2509:51
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class PolicyRuleAdapter extends CommonAdapter<LowRuleResp.PolicyListBean> {
    public PolicyRuleAdapter(Context context, int layoutId, List<LowRuleResp.PolicyListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder,LowRuleResp.PolicyListBean policyListBean, int position) {
        viewHolder.setText(R.id.tv_express_text, policyListBean.getTitle());
        viewHolder.setText(R.id.tv_time, policyListBean.getCreateTime());
        viewHolder.setText(R.id.tv_content, policyListBean.getContent());
        ((TextView) viewHolder.getView(R.id.tv_notice)).setText(SpanUtils.getNoticeSpan("公告"));
    }
}
