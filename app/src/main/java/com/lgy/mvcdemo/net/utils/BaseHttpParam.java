package com.lgy.mvcdemo.net.utils;

import com.lgy.mvcdemo.net.model.LegalParam;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/19.
 */

public abstract class BaseHttpParam {

    protected HashMap<String, String> paramMap;

    private boolean isNeekToken;

    private boolean isNeedProgress;

    private HttpMethod httpMethod;//请求类型 get  put delete  post path

    private String tag;//请求标识

    protected LegalParam legalParam;

    public BaseHttpParam() {
        paramMap = new HashMap<>();
        legalParam=new LegalParam();
    }

    public boolean isNeekToken() {
        return isNeekToken;
    }

    public void setNeekToken(boolean neekToken) {
        isNeekToken = neekToken;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isNeedProgress() {
        return isNeedProgress;
    }

    public void setNeedProgress(boolean needProgress) {
        isNeedProgress = needProgress;
    }

    abstract protected LegalParam isParamLegal();//是否参数合法
}
