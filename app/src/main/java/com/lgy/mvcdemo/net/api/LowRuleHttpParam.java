package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 * 获取政策法规（command=3）
 请求方式：POST
 */

public class LowRuleHttpParam extends BaseHttpParam {
    public LowRuleHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(3);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {
        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        legalParam.setLegal(true);
        return legalParam;
    }
}
