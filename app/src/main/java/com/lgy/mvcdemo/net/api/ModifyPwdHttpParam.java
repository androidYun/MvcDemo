package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 */

public class ModifyPwdHttpParam extends BaseHttpParam {
    public String oldPass;

    public String newPass;

    public String againNewPass;


    public ModifyPwdHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(7);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {
        paramMap.put("oldPass", oldPass);
        paramMap.put("newPass", newPass);
        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        if (StringUtils.isEmpty(oldPass)) {
            legalParam.setErrorMsg("旧密码不能为空");
            return legalParam;
        }
        if (StringUtils.isEmpty(newPass)) {
            legalParam.setErrorMsg("新密码不能为空");
            return legalParam;
        }
        if (StringUtils.isEmpty(againNewPass)) {
            legalParam.setErrorMsg("新密码不能为空");
            return legalParam;
        }
        if (!newPass.equals(againNewPass)) {
            legalParam.setErrorMsg("两次密码不一致,请重新输入");
            return legalParam;
        }
        legalParam.setLegal(true);
        return legalParam;
    }
}
