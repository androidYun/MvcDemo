package com.lgy.mvcdemo.ui.adapter;

import android.content.Context;
import android.view.View;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.model.resp.SearchBuildResp;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by ${lgy} on 2018/1/2509:51
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class BuildAdapter extends CommonAdapter<SearchBuildResp.BuildListBean> {
    public BuildAdapter(Context context, int layoutId, List<SearchBuildResp.BuildListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(final ViewHolder viewHolder, SearchBuildResp.BuildListBean buildListBean, final int position) {
        viewHolder.setText(R.id.tv_build_name, buildListBean.getBuildName());
        viewHolder.setOnClickListener(R.id.ll_item, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view, viewHolder, position);
            }
        });

    }
}
