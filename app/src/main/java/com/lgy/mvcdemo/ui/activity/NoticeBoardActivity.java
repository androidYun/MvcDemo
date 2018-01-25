package com.lgy.mvcdemo.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.MessageHttpParam;
import com.lgy.mvcdemo.view.NaviTitleView;

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

    @Override
    public int getContentViewId() {
        return R.layout.activity_notice_board;
    }

    @Override
    protected void initView() {
        super.initView();
        rvNotice.setLayoutManager(new LinearLayoutManager(this));
        messageHttpParam = new MessageHttpParam();
        httpManger.doPostHttp(messageHttpParam);

    }
}
