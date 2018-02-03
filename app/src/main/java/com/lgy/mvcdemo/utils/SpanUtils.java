package com.lgy.mvcdemo.utils;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;

/**
 * Created by ${lgy} on 2018/1/2915:19
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class SpanUtils {

    /**
     * 获取通知不同大小字体
     * @param str
     * @return
     */
    public static SpannableString getNoticeSpan(String str) {
        SpannableString spanStr = new SpannableString(str);
        spanStr.setSpan(new AbsoluteSizeSpan(10, true), 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spanStr;
    }
}
