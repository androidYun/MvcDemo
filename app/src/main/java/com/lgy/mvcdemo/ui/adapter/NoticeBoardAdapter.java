package com.lgy.mvcdemo.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.model.resp.NoticeBoardResp;
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

public class NoticeBoardAdapter extends CommonAdapter<NoticeBoardResp.NoticeListBean> {
    public NoticeBoardAdapter(Context context, int layoutId, List<NoticeBoardResp.NoticeListBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder, NoticeBoardResp.NoticeListBean noticeListBean, int position) {
        viewHolder.setText(R.id.tv_express_text, noticeListBean.getTitle());
        viewHolder.setText(R.id.tv_time, noticeListBean.getCreateTime());
        viewHolder.setText(R.id.tv_content, noticeListBean.getContent());
        ((TextView) viewHolder.getView(R.id.tv_notice)).setText(SpanUtils.getNoticeSpan("公告"));
        if (position == 0) {
            viewHolder.getView(R.id.view_top_line).setVisibility(View.INVISIBLE);
        } else {
            viewHolder.setVisible(R.id.view_top_line, true);
        }
    }
}
