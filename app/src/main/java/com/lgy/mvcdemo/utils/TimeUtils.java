package com.lgy.mvcdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ${lgy} on 2018/1/2610:42
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class TimeUtils {
    /**
     * 获取当前年份
     *
     * @return
     */
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 格式化时间
     *
     * @param date
     * @return
     */
    public static String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


}
