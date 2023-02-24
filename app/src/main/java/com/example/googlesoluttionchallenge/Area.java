package com.example.googlesoluttionchallenge;
import java.util.Date;

public class Area {

    private String name;
    private String grassType;
    private Date lastWatered;
    private String location;

    public Area(String name, String grassType, Date lastWatered, String location) {
        this.name = name;
        this.grassType = grassType;
        this.lastWatered = lastWatered;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getGrassType() {
        return grassType;
    }

    public Date getLastWatered() {
        return lastWatered;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrassType(String grassType) {
        this.grassType = grassType;
    }

    public void setLastWatered(Date lastWatered) {
        this.lastWatered = lastWatered;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

