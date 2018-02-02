package com.lgy.mvcdemo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/1/23.
 */

public class StringUtils {

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0 || str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String getReplaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
