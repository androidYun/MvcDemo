package com.lgy.mvcdemo.event;

/**
 * Created by Administrator on 2018/1/26.
 */

public class SearchBuildEvent {
    private int buildId;
    private String buildName;

    public SearchBuildEvent(int buildId, String buildName) {
        this.buildId = buildId;
        this.buildName = buildName;
    }

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
