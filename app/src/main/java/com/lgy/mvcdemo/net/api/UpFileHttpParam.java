package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class UpFileHttpParam extends BaseHttpParam {
    public String type;

    public String id;

    public String imgFile;

    public UpFileHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(8);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {
        paramMap.put("type", type);
        paramMap.put("imgFile", imgFile);
        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        if (StringUtils.isEmpty(type)) {
            legalParam.setErrorMsg("账号不能为空");
            return legalParam;
        }
        if (StringUtils.isEmpty(id)) {
            legalParam.setErrorMsg("密码不能为空");
            return legalParam;
        }
        legalParam.setLegal(true);
        return legalParam;
    }
}
