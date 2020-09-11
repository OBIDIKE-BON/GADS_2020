package com.stackfloat.gads2020.services;

public class Leader {
    private String name;
    private String country;
    private String badgeUrl;

    public Leader(String name, String country, String badgeUrl) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
