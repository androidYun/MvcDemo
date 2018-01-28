package com.lgy.mvcdemo.net.utils;

import android.app.Activity;

import com.lgy.mvcdemo.listener.HttpListener;
import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.callback.JsonCallback;
import com.lgy.mvcdemo.net.callback.StringCallback;
import com.lgy.mvcdemo.net.model.BaseResp;
import com.lgy.mvcdemo.utils.FastJsonUtil;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

/**
 * Created by Administrator on 2018/1/19.
 */

public class HttpManger {
    private HttpListener httpListener;

    private Activity mActivity;
    String API_SERVER_URL = "http://w.kjjl100.com/handle/getdata.ashx";

    public HttpManger(HttpListener httpListener, Activity mActivity) {
        this.httpListener = httpListener;
        this.mActivity = mActivity;
    }

    public void doPostHttp(final BaseHttpParam baseHttpParam) {
        if (!baseHttpParam.isParamLegal().isLegal()) {
            httpListener.onFail(0, baseHttpParam.isParamLegal().getErrorMsg());
            return;
        }
        JSONObject jsonObject = new JSONObject(baseHttpParam.getParamMap());
        OkGo.<String>post(API_SERVER_URL).upJson(jsonObject.toString()).tag(baseHttpParam.getTag()).execute(new StringCallback(mActivity, baseHttpParam.isNeedProgress()) {
            @Override
            public void onSuccess(Response<String> response) {
                String result = response.body();
                if (StringUtils.isEmpty(result)) {
                    httpListener.onFail(baseHttpParam.getCommand(), "请求数据失败");
                } else {
                    BaseResp baseResp = FastJsonUtil.getObject(result, BaseResp.class);
                    if (baseResp.getResult() == 1||baseResp.getResult()==0) {//成功
                        httpListener.onSuccess(baseResp.getCommand(), result);
                    } else {
                        httpListener.onFail(baseResp.getCommand(), baseResp.getErrorMsg());
                    }
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                int code = response.code();
                httpListener.onFail(baseHttpParam.getCommand(), "请求失败");
            }
        });

    }

    public void doGetHttp(BaseHttpParam baseHttpParam) {
        if (!baseHttpParam.isParamLegal().isLegal()) {
            httpListener.onFail(0, baseHttpParam.isParamLegal().getErrorMsg());
            return;
        }
        OkGo.<JSONObject>get(API_SERVER_URL).params(baseHttpParam.getParamMap()).tag(baseHttpParam.getTag()).execute(new JsonCallback<JSONObject>(mActivity, baseHttpParam.isNeedProgress()) {

            @Override
            public void onSuccess(Response<JSONObject> response) {
                //成功
                httpListener.onSuccess(0, response.body().toString());
            }

            @Override
            public void onError(Response<JSONObject> response) {
                super.onError(response);
                httpListener.onFail(0, response.message());
            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }
}
