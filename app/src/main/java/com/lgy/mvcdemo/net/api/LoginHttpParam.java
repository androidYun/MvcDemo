package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class LoginHttpParam extends BaseHttpParam {
    public String LoginName;

    public String LoginPwd;


    public LoginHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(1);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {
        paramMap.put("LoginName", LoginName);
        paramMap.put("LoginPwd", LoginPwd);
        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        if (StringUtils.isEmpty(LoginName)) {
            legalParam.setErrorMsg("账号不能为空");
            return legalParam;
        }
        if (StringUtils.isEmpty(LoginPwd)) {
            legalParam.setErrorMsg("密码不能为空");
            return legalParam;
        }
        legalParam.setLegal(true);
        return legalParam;
    }
}
