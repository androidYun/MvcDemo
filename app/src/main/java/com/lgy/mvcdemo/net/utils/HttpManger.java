package com.lgy.mvcdemo.net.utils;

import android.app.Activity;

import com.lgy.mvcdemo.listener.HttpListener;
import com.lgy.mvcdemo.net.callback.JsonCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpMethod;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;

import org.json.JSONObject;

/**
 * Created by Administrator on 2018/1/19.
 */

public class HttpManger {
    private HttpListener httpListener;

    private Activity mActivity;

    public HttpManger(HttpListener httpListener, Activity mActivity) {
        this.httpListener = httpListener;
        this.mActivity = mActivity;
    }

    public void doHttp(BaseHttpParam baseHttpParam) {
        GetRequest<JSONObject> getRequest = null;
        if (baseHttpParam.getHttpMethod() == HttpMethod.GET) {
            getRequest = OkGo.<JSONObject>get("").tag(baseHttpParam.getTag());
        }
        getRequest.execute(new JsonCallback<JSONObject>(mActivity,baseHttpParam.isNeedProgress()) {
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

    public void doGetHttp(BaseHttpParam baseHttpParam) {
        if(baseHttpParam.isParamLegal().isLegal()){
            httpListener.onFail(0,baseHttpParam.isParamLegal().getErrorMsg());
            return;
        }
        OkGo.<JSONObject>get("").params(baseHttpParam.paramMap).tag(baseHttpParam.getTag()).execute(new JsonCallback<JSONObject>(mActivity,baseHttpParam.isNeedProgress()) {

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
