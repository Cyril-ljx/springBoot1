package com.neusoft.demosb.entity;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 11:12 2020/5/28
 */
public class AdminQuery extends Admin {
    private String startTime;
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {

        return super.toString() + "AdminQuery{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
