package com.lgy.mvcdemo.net.model.resp;

import com.lgy.mvcdemo.net.model.BaseResp;

import java.io.Serializable;

/**
 * Created by ${lgy} on 2018/1/2508:40
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LoginResp extends BaseResp implements Serializable {

    /**
     * MonthNum : 1
     * dayNum : 1
     * headImg : null
     * sliceId : 0
     * userId : 1
     * weekNum : 1
     */

    private int MonthNum;
    private int dayNum;
    private String  headImg;
    private int sliceId;
    private String  userId;
    private int weekNum;

    public int getMonthNum() {
        return MonthNum;
    }

    public void setMonthNum(int MonthNum) {
        this.MonthNum = MonthNum;
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public int getSliceId() {
        return sliceId;
    }

    public void setSliceId(int sliceId) {
        this.sliceId = sliceId;
    }



    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }
}
