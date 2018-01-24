/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lgy.mvcdemo.net.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Window;

import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.Type;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：默认将返回的数据解析成需要的Bean,可以是 BaseBean，String，List，Map
 * 修订历史：
 * ================================================
 */
public abstract class JsonCallback<T> extends AbsCallback<T> {

    private Type type;
    private Class<T> clazz;

    private Activity activity;

    private boolean isNeedProgress;

    private ProgressDialog dialog;//对话框


    public JsonCallback(Activity activity, boolean isNeedProgress) {
        this.activity = activity;
        this.isNeedProgress = isNeedProgress;
        if (isNeedProgress && dialog != null) {
            dialog = new ProgressDialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setMessage("请求网络中...");
        }
    }

    public JsonCallback(Type type) {
        this.type = type;
    }

    public JsonCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        super.onStart(request);
        if (isNeedProgress && dialog != null && dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onSuccess(Response<T> response) {

    }

    @Override
    public T convertResponse(okhttp3.Response response) throws Throwable {
        return null;
    }
//    /**
//     * 该方法是子线程处理，不能做ui相关的工作
//     * 主要作用是解析网络返回的 response 对象,生产onSuccess回调中需要的数据对象
//     * 这里的解析工作不同的业务逻辑基本都不一样,所以需要自己实现,以下给出的时模板代码,实际使用根据需要修改
//     */
//    @Override
//    public T convertResponse(Response response) throws Throwable {//  返回json:【{"command":1,"result":1,"errorMsg":"","userId":"1"}】 180,6ms
//     //   {"command":1,"result":0,"errorMsg":"手机帐号或者密码不正确","userId":"0"}
//        // {"command":1,"result":1,"errorMsg":"","userId":"1"}
//        LogUtil.d("中药数据" + response.message()+"      "+response.body().string() +"        内容"+ response.body());
//        // 重要的事情说三遍，不同的业务，这里的代码逻辑都不一样，如果你不修改，那么基本不可用
//        // 重要的事情说三遍，不同的业务，这里的代码逻辑都不一样，如果你不修改，那么基本不可用
//        // 重要的事情说三遍，不同的业务，这里的代码逻辑都不一样，如果你不修改，那么基本不可用
//
//        //详细自定义的原理和文档，看这里： https://github.com/jeasonlzy/okhttp-OkGo/wiki/JsonCallback
//
//        if (type == null) {
//            if (clazz == null) {
//                Type genType = getClass().getGenericSuperclass();
//                type = ((ParameterizedType) genType).getActualTypeArguments()[0];
//            } else {
//                JsonConvert<T> convert = new JsonConvert<>(clazz);
//                return convert.convertResponse(response);
//            }
//        }
//
//        JsonConvert<T> convert = new JsonConvert<>(type);
//        return convert.convertResponse(response);
//    }

    @Override
    public void onFinish() {
        if (isNeedProgress && dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
