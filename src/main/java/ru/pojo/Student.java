package ru.pojo;

import java.util.Date;

public class Student {
    private String name;
    private int group;
    private Date dateStudy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getDateStudy() {
        return dateStudy;
    }

    public void setDateStudy(Date dateStudy) {
        this.dateStudy = dateStudy;
    }
}
