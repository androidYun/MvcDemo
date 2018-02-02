package com.lgy.mvcdemo.net.model.resp;

import java.util.List;

/**
 * Created by ${lgy} on 2018/1/2510:21
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class SearchBuildResp {


    /**
     * command : 100
     * result : 1
     * errorMsg :
     * buildList : [{"buildId":1,"buildName":"清华园"}]
     */

    private int command;
    private int result;
    private String errorMsg;
    private List<BuildListBean> buildList;

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

    public List<BuildListBean> getBuildList() {
        return buildList;
    }

    public void setBuildList(List<BuildListBean> buildList) {
        this.buildList = buildList;
    }

    public static class BuildListBean {
        private int buildId;
        private String buildName;

        public int getBuildId() {
            return buildId;
        }

        public void setBuildId(int buildId) {
            this.buildId = buildId;
        }

        public String getBuildName() {
            return buildName;
        }

        public void setBuildName(String buildName) {
            this.buildName = buildName;
        }
    }
}
