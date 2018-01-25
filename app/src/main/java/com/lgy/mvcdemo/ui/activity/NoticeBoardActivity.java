package com.lgy.mvcdemo.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.MessageHttpParam;
import com.lgy.mvcdemo.net.model.resp.NoticeBoardResp;
import com.lgy.mvcdemo.ui.adapter.NoticeBoardAdapter;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.view.NaviTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/24.
 */

public class NoticeBoardActivity extends BaseActivity {


    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.rv_notice)
    RecyclerView rvNotice;

    MessageHttpParam messageHttpParam;

    private NoticeBoardAdapter noticeBoardAdapter;

    private List<NoticeBoardResp.NoticeListBean> mDataList = new ArrayList<>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_notice_board;
    }

    @Override
    protected void initView() {
        super.initView();
        rvNotice.setLayoutManager(new LinearLayoutManager(this));
        noticeBoardAdapter = new NoticeBoardAdapter(this, R.layout.item_notice_layout, mDataList);
        rvNotice.setAdapter(noticeBoardAdapter);
        messageHttpParam = new MessageHttpParam();
        httpManger.doPostHttp(messageHttpParam);

    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == messageHttpParam.getCommand()) {
            NoticeBoardResp noticeBoardResp = FastJsonUtil.getObject(result, NoticeBoardResp.class);
            if (noticeBoardResp.getNoticeList() != null && noticeBoardResp.getNoticeList().size() > 0) {
                mDataList.clear();
                mDataList.addAll(noticeBoardResp.getNoticeList());
                noticeBoardAdapter.notifyDataSetChanged();
            }
        }
    }
}
