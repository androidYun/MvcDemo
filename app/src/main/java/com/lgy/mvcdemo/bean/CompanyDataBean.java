package com.lgy.mvcdemo.bean;

/**
 * Created by ${lgy} on 2018/1/2515:34
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class CompanyDataBean {
    private String name;

    private String value;

    public CompanyDataBean(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
