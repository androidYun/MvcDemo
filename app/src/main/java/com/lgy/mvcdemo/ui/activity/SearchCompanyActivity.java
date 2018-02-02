package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.SearchCompanyHttpParam;
import com.lgy.mvcdemo.net.model.resp.SearchCompanyResp;
import com.lgy.mvcdemo.ui.adapter.SearchCompanyAdapter;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.utils.SysUtils;
import com.lgy.mvcdemo.view.NaviTitleView;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/24.
 */


public class SearchCompanyActivity extends BaseActivity implements MultiItemTypeAdapter.OnItemClickListener {
    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.ev_search)
    EditText evSearch;
    @BindView(R.id.rv_notice)
    RecyclerView rvNotice;
    @BindView(R.id.tv_search_title)
    TextView tvSearchTitle;
    private SearchCompanyHttpParam searchCompanyHttpParam;

    private SearchCompanyAdapter searchCompanyAdapter;

    private List<SearchCompanyResp.CompanyListBean> mDataList = new ArrayList<>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_search_company;
    }

    @Override
    protected void initView() {
        super.initView();
        searchCompanyHttpParam = new SearchCompanyHttpParam();
        evSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    SysUtils.hideSoftInput(SearchCompanyActivity.this, evSearch);
                    return true;
                }
                searchCompanyHttpParam.companyName = evSearch.getText().toString().trim();
                searchCompanyHttpParam.companyName = "郑州智领科技有限公司";
                httpManger.doPostHttp(searchCompanyHttpParam);
                return false;
            }
        });
        rvNotice.setLayoutManager(new LinearLayoutManager(this));
        searchCompanyAdapter = new SearchCompanyAdapter(this, R.layout.item_company_detail, mDataList);
        searchCompanyAdapter.setOnItemClickListener(this);
        rvNotice.setAdapter(searchCompanyAdapter);
    }


    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == searchCompanyHttpParam.getCommand()) {
            SearchCompanyResp searchCompanyResp = FastJsonUtil.getObject(result, SearchCompanyResp.class);
            if (searchCompanyResp != null && searchCompanyResp.getCompanyList().size() > 0) {
                mDataList.clear();
                mDataList.addAll(searchCompanyResp.getCompanyList());
                searchCompanyAdapter.notifyDataSetChanged();
                tvSearchTitle.setVisibility(View.VISIBLE);
                tvSearchTitle.setText("找到搜索内容共" + searchCompanyResp.getCompanyList().size() + "个");
            } else {
                tvSearchTitle.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onFail(int command, String errorMsg) {
        super.onFail(command, errorMsg);
        tvSearchTitle.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
        Intent intent = new Intent(this, CompanyDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(SearchCompanyResp.CompanyListBean.class.getName(), mDataList.get(i));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }
}
