package com.lgy.mvcdemo.utils;

/**
 * Created by Administrator on 2018/1/23.
 */

public class StringUtils {

    public static boolean isEmpty(String str){
        if(str==null||str.length()==0||str.isEmpty()){
            return true;
        }
        return false;
    }
}
