package com.lgy.mvcdemo.net.model.resp;

import java.util.List;

/**
 * Created by ${lgy} on 2018/1/2510:21
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class NoticeBoardResp {


    /**
     * command : 2
     * result : 1
     * errorMsg :
     * noticeList : [{"content":"请各位同事抓紧整理17年楼宇采集信息，并做出统计，提交部门进行考核绩效。","createId":1,"createTime":"2018/1/15 6:18:28","title":"关于2017年年底收尾工作的通知"},{"content":"经领导研究决定春节放假时间为：2018年2月10日起至2018年2月20日，该公告适用于单元全体同事","createId":1,"createTime":"2018/1/15 6:18:28","title":"2018年春节放假通知"}]
     */

    private int command;
    private int result;
    private String errorMsg;
    private List<NoticeListBean> noticeList;

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<NoticeListBean> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<NoticeListBean> noticeList) {
        this.noticeList = noticeList;
    }

    public static class NoticeListBean {
        /**
         * content : 请各位同事抓紧整理17年楼宇采集信息，并做出统计，提交部门进行考核绩效。
         * createId : 1
         * createTime : 2018/1/15 6:18:28
         * title : 关于2017年年底收尾工作的通知
         */

        private String content;
        private int createId;
        private String createTime;
        private String title;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getCreateId() {
            return createId;
        }

        public void setCreateId(int createId) {
            this.createId = createId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
