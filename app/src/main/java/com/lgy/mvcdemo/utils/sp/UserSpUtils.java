package com.lgy.mvcdemo.utils.sp;

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
}
