package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class CheckBuildHttpParam extends BaseHttpParam {
    public String buildName;



    public CheckBuildHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(100);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {
        paramMap.put("buildName", buildName);
        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        if (StringUtils.isEmpty(buildName)) {
            legalParam.setErrorMsg("楼宇名称不能为空");
            return legalParam;
        }
        legalParam.setLegal(true);
        return legalParam;
    }
}
