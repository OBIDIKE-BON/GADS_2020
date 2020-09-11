package com.stackfloat.gads2020.services;

public class IQLeader extends Leader {

    private int score;

    public IQLeader(String name, String country, String badgeUrl, int score) {
        super(name, country, badgeUrl);
        this.score = score;
    }

    @Override
    public String toString() {
        return "LearnerLeader{" +
                "score=" + score +
                '}';
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
