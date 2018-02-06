package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ModifyHeadHttpParam extends BaseHttpParam {
    public String imgPath;


    public ModifyHeadHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(9);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {

        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        if (StringUtils.isEmpty(imgPath)) {
            legalParam.setErrorMsg("头像链接不能为空");
            return legalParam;
        }
        legalParam.setLegal(true);
        return legalParam;
    }
}
