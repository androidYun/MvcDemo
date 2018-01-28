package com.lgy.mvcdemo.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.event.SearchBuildEvent;
import com.lgy.mvcdemo.net.api.SearchBuildHttpParam;
import com.lgy.mvcdemo.net.model.resp.SearchBuildResp;
import com.lgy.mvcdemo.ui.adapter.BuildAdapter;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.utils.SysUtils;
import com.lgy.mvcdemo.view.NaviTitleView;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ${lgy} on 2018/1/2617:19
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class SearchBuildActivity extends BaseActivity  implements MultiItemTypeAdapter.OnItemClickListener{
    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.ev_search)
    EditText evSearch;
    @BindView(R.id.tv_search_title)
    TextView tvSearchTitle;
    @BindView(R.id.rv_search_build)
    RecyclerView rvSearchBuild;

    private SearchBuildHttpParam searchBuildHttpParam;

    private BuildAdapter buildAdapter;

    private List<SearchBuildResp.BuildListBean> mDataList = new ArrayList<>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_search_build;
    }

    @Override
    protected void initView() {
        super.initView();
        searchBuildHttpParam = new SearchBuildHttpParam();
        evSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    SysUtils.hideSoftInput(SearchBuildActivity.this, evSearch);
                    return true;
                }
                searchBuildHttpParam.buildName = evSearch.getText().toString().trim();
                searchBuildHttpParam.buildName = "清华园";
                httpManger.doPostHttp(searchBuildHttpParam);
                return false;
            }
        });
        rvSearchBuild.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void initData() {
        super.initData();
        buildAdapter = new BuildAdapter(this, R.layout.item_build_layout, mDataList);
        buildAdapter.setOnItemClickListener(this);
        rvSearchBuild.setAdapter(buildAdapter);
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == searchBuildHttpParam.getCommand()) {
            SearchBuildResp searchBuildResp = FastJsonUtil.getObject(result, SearchBuildResp.class);
            if (searchBuildResp != null && searchBuildResp.getBuildList().size() > 0) {
                mDataList.clear();
                mDataList.addAll(searchBuildResp.getBuildList());
                buildAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
        EventBus.getDefault().post(new SearchBuildEvent(mDataList.get(i).getBuildId(),mDataList.get(i).getBuildName()));
        finish();
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
        return false;
    }
}
