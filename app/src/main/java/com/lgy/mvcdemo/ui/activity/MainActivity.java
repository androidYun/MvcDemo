package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.net.api.VersionUpdateHttpParam;
import com.lgy.mvcdemo.net.model.resp.LoginResp;
import com.lgy.mvcdemo.net.model.resp.VersionUpdateResp;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.utils.SysUtils;
import com.lgy.mvcdemo.utils.imageutils.ImageLoaderProxy;
import com.lgy.mvcdemo.utils.sp.UserSpUtils;
import com.lgy.mvcdemo.view.CircleImageView;
import com.lgy.mvcdemo.view.NaviTitleView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadListener;
import com.lzy.okserver.download.DownloadTask;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.navi_view)
    NaviTitleView naviView;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.view_top)
    View viewTop;
    @BindView(R.id.tv_day_add_company)
    TextView tvDayAddCompany;
    @BindView(R.id.tv_week_add_company)
    TextView tvWeekAddCompany;
    @BindView(R.id.tv_month_add_company)
    TextView tvMonthAddCompany;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.tv_rule)
    TextView tvRule;
    @BindView(R.id.tv_add_company)
    TextView tvAddCompany;
    @BindView(R.id.tv_search_company)
    TextView tvSearchCompany;
    @BindView(R.id.tv_build_infor)
    TextView tvBuildInfor;
    @BindView(R.id.tv_set)
    TextView tvSet;
    VersionUpdateHttpParam versionUpdateHttpParam;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        naviView.visibleLeftRes(false);
        versionUpdateHttpParam = new VersionUpdateHttpParam();
        httpManger.doPostHttp(versionUpdateHttpParam);
    }

    @Override
    public void initData() {
        super.initData();
        LoginResp userBean = UserSpUtils.getUserBean();
        tvDayAddCompany.setText(userBean.getDayNum() + "");
        tvWeekAddCompany.setText(userBean.getWeekNum() + "");
        tvMonthAddCompany.setText(userBean.getMonthNum() + "");
        ImageLoaderProxy.getInstace().displayImage("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517217538709&di=12ee2d56e468ebfc8c49be894883d27f&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201509%2F2015091008.jpg", ivHead, R.mipmap.default_user);
        tvName.setText(UserSpUtils.getUserName());

    }

    public void downLoad(String url) {

    }

    @OnClick({R.id.tv_notice, R.id.tv_rule, R.id.tv_add_company, R.id.tv_search_company, R.id.tv_build_infor, R.id.tv_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_notice:
                startActivity(new Intent(this, NoticeBoardActivity.class));
                break;
            case R.id.tv_rule:
                startActivity(new Intent(this, PolicyRuleActivity.class));
                break;
            case R.id.tv_add_company:
                startActivity(new Intent(this, AddCompanyActivity.class));
                break;
            case R.id.tv_search_company:
                startActivity(new Intent(this, SearchCompanyActivity.class));
                break;
            case R.id.tv_build_infor:
                Intent intent = new Intent(this, SearchBuildActivity.class);
                intent.putExtra("code", SearchBuildActivity.LOOK_DETAIL_CODE);
                startActivity(intent);
                break;
            case R.id.tv_set:
                startActivity(new Intent(this, SetActivity.class));
                break;
        }
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == versionUpdateHttpParam.getCommand()) {
            VersionUpdateResp versionUpdateResp = FastJsonUtil.getObject(result, VersionUpdateResp.class);
            int versionCode = SysUtils.getInatcne().getVersionCode(this);
            VersionUpdateResp.DataBean data = versionUpdateResp.data;
            String url="https://www.baidu.com/link?url=yOpROmJvy8bn_A-jWqlL3-tZaWrlMh_WdwZ5YWZTmDD8cr4jLNyOb9pNW_15Scw3zEIQmynZY3P7bhGJyzDDMujpttR0TOxkNUI-Aa46eku&wd=&eqid=d0bcdf810003b878000000025a7ac5ba";
       //     if (data.versionCode > versionCode) {
                //这里只是演示，表示请求可以传参，怎么传都行，和okgo使用方法一样
                GetRequest<File> request = OkGo.<File>get(url);
                DownloadTask downloadTask = OkDownload.request(url, request)//
                        .save()//
                        .register(new DesListener("DesListener"));//
                downloadTask.start();
         //   }
        }
    }

    private class DesListener extends DownloadListener {

        DesListener(String tag) {
            super(tag);
        }

        @Override
        public void onStart(Progress progress) {
        }

        @Override
        public void onProgress(Progress progress) {

        }

        @Override
        public void onFinish(File file, Progress progress) {
        }

        @Override
        public void onRemove(Progress progress) {
        }

        @Override
        public void onError(Progress progress) {
            Throwable throwable = progress.exception;
            if (throwable != null) throwable.printStackTrace();
        }
    }
}
