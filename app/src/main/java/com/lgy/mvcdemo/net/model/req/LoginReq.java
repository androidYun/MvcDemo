package com.lgy.mvcdemo.net.model.req;

/**
 * Created by ${lgy} on 2018/1/2414:07
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LoginReq extends BaseReq {

    private String LoginName;

    private String LoginPwd;

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getLoginPwd() {
        return LoginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        LoginPwd = loginPwd;
    }
}
