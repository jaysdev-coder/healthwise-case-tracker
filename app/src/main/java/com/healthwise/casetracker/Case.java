package com.healthwise.casetracker;

public class Case {
    private String Age_Group;
    private String Classification_Reported;
    private String HA;

    public Case(String age_Group, String classification_Reported, String HA, String reported_Date, String sex) {
        Age_Group = age_Group;
        Classification_Reported = classification_Reported;
        this.HA = HA;
        Reported_Date = reported_Date;
        Sex = sex;
    }

    private String Reported_Date;
    private String Sex;

    public Case() {
    }


    public String getAge_Group() {
        return Age_Group;
    }

    public void setAge_Group(String age_Group) {
        Age_Group = age_Group;
    }

    public String getClassification_Reported() {
        return Classification_Reported;
    }

    public void setClassification_Reported(String classification_Reported) {
        Classification_Reported = classification_Reported;
    }

    public String getHA() {
        return HA;
    }

    public void setHA(String HA) {
        this.HA = HA;
    }

    public String getReported_Date() {
        return Reported_Date;
    }

    public void setReported_Date(String reported_Date) {
        Reported_Date = reported_Date;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
}
