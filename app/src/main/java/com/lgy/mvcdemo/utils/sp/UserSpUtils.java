package com.lgy.mvcdemo.utils.sp;

/**
 * Created by ${lgy} on 2018/1/2409:15
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class UserSpUtils {

    public static int getUserId() {
        return (int) SPUtil.get("userId", 0);
    }

    public static void setUserId(int userId) {
        SPUtil.put("userId", userId);
    }
}
