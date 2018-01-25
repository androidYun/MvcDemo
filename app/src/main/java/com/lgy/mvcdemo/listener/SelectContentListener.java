package com.lgy.mvcdemo.listener;

import com.lgy.mvcdemo.bean.CompanyDataBean;

/**
 * Created by ${lgy} on 2017/11/2413:51
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public interface SelectContentListener {

    void onSelectSuccess(int code, CompanyDataBean companyDataBean);
}
