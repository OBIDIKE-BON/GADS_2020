package com.stackfloat.gads2020.services;

public class LearnerLeader extends Leader {

    private int hours;

    public LearnerLeader(String name, String country, String badgeUrl, int hours) {
        super(name, country, badgeUrl);
        this.hours = hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "LearnerLeader{" +
                "hours=" + hours +
                '}';
    }

}