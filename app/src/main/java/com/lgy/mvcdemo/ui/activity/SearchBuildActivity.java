package com.lgy.mvcdemo.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.view.NaviTitleView;

import butterknife.BindView;

/**
 * Created by ${lgy} on 2018/1/2617:19
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class SearchBuildActivity extends BaseActivity {
    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.ev_search)
    EditText evSearch;
    @BindView(R.id.tv_search_title)
    TextView tvSearchTitle;
    @BindView(R.id.rv_search_build)
    RecyclerView rvSearchBuild;

    @Override
    public int getContentViewId() {
        return R.layout.activity_search_build;
    }
}
