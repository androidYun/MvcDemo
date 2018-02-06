package com.lgy.mvcdemo.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.listener.AlbumImageListener;
import com.lgy.mvcdemo.net.api.ModifyHeadHttpParam;
import com.lgy.mvcdemo.net.api.UpFileHttpParam;
import com.lgy.mvcdemo.net.model.resp.LoginResp;
import com.lgy.mvcdemo.utils.AlbumUtils;
import com.lgy.mvcdemo.utils.FileUtils;
import com.lgy.mvcdemo.utils.ToastUtil;
import com.lgy.mvcdemo.utils.imageutils.ImageLoaderProxy;
import com.lgy.mvcdemo.utils.sp.UserSpUtils;
import com.lgy.mvcdemo.view.CircleImageView;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SetActivity extends BaseActivity {


    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_type)
    TextView tvType;

    UpFileHttpParam upFileHttpParam;

    ModifyHeadHttpParam modifyHeadHttpParam;

    @Override
    public int getContentViewId() {
        return R.layout.activity_set;
    }

    @Override
    public void initData() {
        super.initData();
        LoginResp userBean = UserSpUtils.getUserBean();
        tvName.setText(UserSpUtils.getUserName());
        ImageLoaderProxy.getInstace().displayImage(userBean.getHeadImg(), ivHead, R.mipmap.default_user);
        upFileHttpParam = new UpFileHttpParam();
        modifyHeadHttpParam = new ModifyHeadHttpParam();
        upFileHttpParam.type = "icon";
        String userId = UserSpUtils.getUserId();
        upFileHttpParam.id = userId;
    }

    @OnClick({R.id.rl_modify_pwd, R.id.rl_modify_head, R.id.rl_back_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_modify_pwd:
                startActivity(new Intent(this, ModifyPwdActivity.class));
                break;
            case R.id.rl_modify_head:
                AlbumUtils.albumImage(this, 100, 1, new AlbumImageListener() {
                    @Override
                    public void onResult(int requestCode, @NonNull ArrayList<String> result) {
                        if (result != null && result.size() > 0) {
                            File file = new File(result.get(0));
                            String base64 = FileUtils.fileToBase64(file);
                            upFileHttpParam.imgFile=base64;
                            httpManger.upLoadFileHttp(upFileHttpParam);
                        }
                    }

                    @Override
                    public void onCancel(int requestCode, @NonNull String result) {
                        ToastUtil.show(SetActivity.this, "取消");
                    }
                });

                break;
            case R.id.rl_back_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }

    @Override
    public void onSuccess(int command, String result) {
        super.onSuccess(command, result);
        if (command == upFileHttpParam.getCommand()) {
            modifyHeadHttpParam.imgPath = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517217538709&di=12ee2d56e468ebfc8c49be894883d27f&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201509%2F2015091008.jpg";
            httpManger.doPostHttp(modifyHeadHttpParam);
        } else if (command == modifyHeadHttpParam.getCommand()) {
            ImageLoaderProxy.getInstace().displayImage("", ivHead);
        }
    }
}
