package com.lgy.mvcdemo.net.model.resp;

/**
 * Created by ${lgy} on 2018/2/717:08
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class VersionUpdateResp {


    /**
     * command : 10
     * result : 0
     * errorMsg : 暂无版本信息
     * data : {"apkUrl":null,"versionCode":0,"versionDesc":null,"versionName":null}
     */

    public int command;
    public int result;
    public String errorMsg;
    public DataBean data;

    public static class DataBean {
        /**
         * apkUrl : null
         * versionCode : 0
         * versionDesc : null
         * versionName : null
         */

        public String apkUrl="https://www.baidu.com/link?url=yOpROmJvy8bn_A-jWqlL3-tZaWrlMh_WdwZ5YWZTmDD8cr4jLNyOb9pNW_15Scw3zEIQmynZY3P7bhGJyzDDMujpttR0TOxkNUI-Aa46eku&wd=&eqid=d0bcdf810003b878000000025a7ac5ba";
        public int versionCode;
        public String versionDesc;
        public String versionName;
    }
}
