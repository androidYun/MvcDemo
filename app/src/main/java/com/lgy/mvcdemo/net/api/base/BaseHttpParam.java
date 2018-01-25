package com.lgy.mvcdemo.net.api.base;

import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.net.model.req.BaseReq;
import com.lgy.mvcdemo.utils.sp.UserSpUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/19.
 */

public abstract class BaseHttpParam {

    protected HashMap<String, String> paramMap;

    public BaseReq baseReq;

    private boolean isNeekToken;

    private boolean isNeedProgress;

    private HttpMethod httpMethod;//请求类型 get  put delete  post path

    private String tag;//请求标识

    protected LegalParam legalParam;

    private int command;//接口编号

    private String  userId;//接口Id


    public BaseHttpParam() {
        userId = UserSpUtils.getUserId();
        paramMap = new HashMap<>();
        paramMap.put("userId", 0 + "");
        legalParam = new LegalParam();
        legalParam.setLegal(false);
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

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        paramMap.put("command", command + "");
        this.command = command;
    }

    public abstract LegalParam isParamLegal();//是否参数合法

    public abstract HashMap<String, String> getParamMap();//是否参数合法
}
