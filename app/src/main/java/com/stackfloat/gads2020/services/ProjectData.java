package com.stackfloat.gads2020.services;

public class ProjectData {
    private String altUrl;
    private String EmailAddress;
    private String LastName;

    @Override
    public String toString() {
        return "ProjectData{" +
                "altUrl='" + altUrl + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                ", LastName='" + LastName + '\'' +
                ", projectLink='" + projectLink + '\'' +
                '}';
    }

    public String getAltUrl() {
        return altUrl;
    }

    public void setAltUrl(String altUrl) {
        this.altUrl = altUrl;
    }

    public ProjectData(String altUrl, String emailAddress, String lastName, String projectLink) {
        this.altUrl = altUrl;
        EmailAddress = emailAddress;
        LastName = lastName;
        this.projectLink = projectLink;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    private String projectLink;
}
