package com.lgy.mvcdemo.net.model;

/**
 * Created by Administrator on 2018/1/23.
 */

public class LegalParam {
    private boolean isLegal;

    private String errorMsg;

    public boolean isLegal() {
        return isLegal;
    }

    public void setLegal(boolean legal) {
        isLegal = legal;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
