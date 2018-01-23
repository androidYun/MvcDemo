package com.lgy.mvcdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lgy.mvcdemo.net.httpparam.LoginHttpParam;
import com.lgy.mvcdemo.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpManger.doGetHttp(new LoginHttpParam());
    }
}
