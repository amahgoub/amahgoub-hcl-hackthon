package com.ing.hackthon.userStatistics;

public class UserStatisticsDTO {

    private int id;
    private int numberOfOverviewHits;
    private int numberOfDetailsHits;
    private boolean isAlerted;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfOverviewHits() {
        return numberOfOverviewHits;
    }

    public void setNumberOfOverviewHits(int numberOfOverviewHits) {
        this.numberOfOverviewHits = numberOfOverviewHits;
    }

    public int getNumberOfDetailsHits() {
        return numberOfDetailsHits;
    }

    public void setNumberOfDetailsHits(int numberOfDetailsHits) {
        this.numberOfDetailsHits = numberOfDetailsHits;
    }

    public boolean isAlerted() {
        return isAlerted;
    }

    public void setAlerted(boolean alerted) {
        isAlerted = alerted;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
