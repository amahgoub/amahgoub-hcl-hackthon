package com.ing.hackthon.userStatistics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ing.hackthon.user.User;

/**
 * Entity for the user statistics domain object
 */
@Entity
public class UserStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int numberOfOverviewHits;
    private int numberOfDetailsHits;
    private boolean isAlerted;
    @OneToOne
    private User user;

    public UserStatistics(int numberOfOverviewHits, int numberOfDetailsHits, boolean isAlerted, int userId) {
        super();
        this.numberOfOverviewHits = numberOfOverviewHits;
        this.numberOfDetailsHits = numberOfDetailsHits;
        this.isAlerted = isAlerted;
        this.user = new User(userId, "", "", "");
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
    public void setAlerted(boolean isAlerted) {
        this.isAlerted = isAlerted;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



}