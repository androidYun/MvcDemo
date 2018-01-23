package com.lgy.mvcdemo.listener;

/**
 * Created by Administrator on 2018/1/19.
 */

public interface HttpListener {
    void onSuccess(int command,String result);

    void onFail(int command,String errorMsg);

    void onLoadingProcess();

    void onHideProcess();
}
