package com.lgy.mvcdemo.net.model;

/**
 * Created by ${lgy} on 2018/1/2410:36
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class BaseResp {//{"command":1,"result":1,"errorMsg":"","userId":"1"}

    private int command;

    private int result;  // 1表示成功  0 表示失败

    private String errorMsg;

    private String userId;

    private String data;

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
