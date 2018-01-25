package com.lgy.mvcdemo.utils.sp;

import com.lgy.mvcdemo.net.model.resp.LoginResp;

/**
 * Created by ${lgy} on 2018/1/2409:15
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class UserSpUtils {
    private final static String USER_ID = "userId";//用户Id

    private final static String USER_NAME = "userName";//用户Id

    private final static String USER_PASSWORD = "userPassword";//用户Id

    private final static String USER_BEAN = "USER_BEAN";//用户实体类


    public static String getUserId() {
        return (String) SPUtil.get(USER_ID, "0");
    }

    public static void setUserId(String userId) {
        SPUtil.put(USER_ID, userId);
    }

    public static String getUserName() {
        return (String) SPUtil.get(USER_NAME, "");
    }

    public static void setUserName(String userName) {
        SPUtil.put(USER_NAME, userName);
    }


    public static String getUserPassword() {
        return (String) SPUtil.get(USER_PASSWORD, "");
    }

    public static void setUserPassword(String userPassword) {
        SPUtil.put(USER_PASSWORD, userPassword);
    }

    public static void setUserBean(LoginResp userBean) {
        SPUtil.putBean(USER_BEAN, userBean);
    }

    public static LoginResp getUserBean() {
        return SPUtil.getBean(USER_BEAN, LoginResp.class);
    }
}
