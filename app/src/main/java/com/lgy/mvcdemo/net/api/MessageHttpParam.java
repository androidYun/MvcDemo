package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class MessageHttpParam extends BaseHttpParam {

    public MessageHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(2);
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
