package com.lgy.mvcdemo.net.httpparam;

import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.net.utils.BaseHttpParam;
import com.lgy.mvcdemo.utils.StringUtils;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class LoginHttpParam extends BaseHttpParam {
    public String LoginName;

    public String LoginPwd;


    public LoginHttpParam() {
        setNeekToken(false);
        setNeedProgress(true);
    }

    public void setParamMap(String LoginName, String LoginPwd) {
        paramMap.clear();
        paramMap.put("LoginName", LoginName);
        paramMap.put("LoginPwd", LoginPwd);
    }

    @Override
    protected LegalParam isParamLegal() {
        if(StringUtils.isEmpty(LoginName)){
            legalParam.setErrorMsg("账号不能为空");
            legalParam.setLegal(false);
        }
        return legalParam;
    }
}
