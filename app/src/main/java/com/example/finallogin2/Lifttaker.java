package com.example.finallogin2;

public class Lifttaker {
    String ownerId;
    String ownerDestination;
    String ownerStartingPoint;
    String time;
    public Lifttaker(){

    }

    public Lifttaker(String ownerId, String ownerDestination, String ownerStartingPoint, String time) {
        this.ownerId = ownerId;
        this.ownerDestination = ownerDestination;
        this.ownerStartingPoint = ownerStartingPoint;
        this.time = time;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerDestination() {
        return ownerDestination;
    }

    public void setOwnerDestination(String ownerDestination) {
        this.ownerDestination = ownerDestination;
    }

    public String getOwnerStartingPoint() {
        return ownerStartingPoint;
    }

    public void setOwnerStartingPoint(String ownerStartingPoint) {
        this.ownerStartingPoint = ownerStartingPoint;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
