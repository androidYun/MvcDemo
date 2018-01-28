package com.lgy.mvcdemo.ui.adapter;

import android.content.Context;
import android.view.View;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.model.resp.SearchCompanyResp;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by ${lgy} on 2018/1/2509:51
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class SearchCompanyAdapter extends CommonAdapter<SearchCompanyResp.CompanyListBean> {
    public SearchCompanyAdapter(Context context, int layoutId, List<SearchCompanyResp.CompanyListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(final ViewHolder viewHolder, SearchCompanyResp.CompanyListBean companyListBean, final int position) {
        viewHolder.setText(R.id.tv_build_no, companyListBean.getPlaceEntity().getBuildName());
        viewHolder.setText(R.id.tv_comunity, companyListBean.getPlaceEntity().getCommunity());
        viewHolder.setText(R.id.tv_industry, companyListBean.getBasicEntity().getIndustry());
        viewHolder.setText(R.id.tv_contactPhone, companyListBean.getBasicEntity().getContactPhone());
        viewHolder.setText(R.id.tv_build_no, companyListBean.getPlaceEntity().getBuildName());
        viewHolder.setOnClickListener(R.id.ll_item, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,viewHolder,position);
            }
        });
    }
}
