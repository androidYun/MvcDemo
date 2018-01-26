package com.lgy.mvcdemo.net.model.resp;

import java.util.List;

/**
 * Created by ${lgy} on 2018/1/2510:21
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class LowRuleResp {


    /**
     * command : 3
     * result : 1
     * errorMsg :
     * policyList : [{"content":"fdsafdsa第一条　为了维护国家基本经济制度，维护社会主义市场经济秩序，明确物的归属，发挥物的效用，保护权利人的物权，根据宪法，制定本法。　　第二条　因物的归属和利用而产生的民事关系，适用本法","createId":1,"createTime":"2018/1/25 6:24:23","title":"十五届三中全会后关于《租权法》的新规定"}]
     */

    public int command;
    public int result;
    public String errorMsg;
    public List<PolicyListBean> policyList;

    public static class PolicyListBean {
        /**
         * content : fdsafdsa第一条　为了维护国家基本经济制度，维护社会主义市场经济秩序，明确物的归属，发挥物的效用，保护权利人的物权，根据宪法，制定本法。　　第二条　因物的归属和利用而产生的民事关系，适用本法
         * createId : 1
         * createTime : 2018/1/25 6:24:23
         * title : 十五届三中全会后关于《租权法》的新规定
         */

        public String content;
        public int createId;
        public String createTime;
        public String title;

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

    public List<PolicyListBean> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<PolicyListBean> policyList) {
        this.policyList = policyList;
    }
}
