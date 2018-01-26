package com.lgy.mvcdemo.net.api;

import com.lgy.mvcdemo.net.api.base.BaseHttpParam;
import com.lgy.mvcdemo.net.model.LegalParam;
import com.lgy.mvcdemo.utils.StringUtils;
import com.lzy.okgo.model.HttpMethod;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/1/23.
 * 查询企业信息（command=5）
 */

public class SearchCompanyHttpParam extends BaseHttpParam {
    public String companyName;



    public SearchCompanyHttpParam() {
        super();
        setHttpMethod(HttpMethod.POST);
        setCommand(5);
        setNeekToken(false);
        setNeedProgress(true);
    }

    @Override
    public HashMap<String, String> getParamMap() {
        paramMap.put("companyName", companyName);
        return paramMap;
    }

    @Override
    public LegalParam isParamLegal() {
        if (StringUtils.isEmpty(companyName)) {
            legalParam.setErrorMsg("公司名称不能为空");
            return legalParam;
        }
        legalParam.setLegal(true);
        return legalParam;
    }
}
