package com.lgy.mvcdemo.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.SearchBuildHttpParam;
import com.lgy.mvcdemo.utils.SysUtils;
import com.lgy.mvcdemo.view.NaviTitleView;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/24.
 */


public class SearchCompanyActivity extends BaseActivity {
    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.ev_search)
    EditText evSearch;
    @BindView(R.id.rv_notice)
    RecyclerView rvNotice;
    private SearchBuildHttpParam searchBuildHttpParam;

    @Override
    protected void initView() {
        super.initView();
        searchBuildHttpParam = new SearchBuildHttpParam();
        evSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    SysUtils.hideSoftInput(SearchCompanyActivity.this, evSearch);
                    return true;
                }
                searchBuildHttpParam.buildName = evSearch.getText().toString().trim();
                httpManger.doPostHttp(searchBuildHttpParam);
                return false;
            }
        });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_notice_board;
    }

}
