package com.example.finallogin2;

public class Lifttaker {
    String OwnerId;
    String OwnerDestination;
    String OwnerStartingPoint;
    String Time;
    public Lifttaker(){

    }

    public Lifttaker(String ownerId, String ownerDestination, String ownerStartingPoint, String time) {
        OwnerId = ownerId;
        OwnerDestination = ownerDestination;
        OwnerStartingPoint = ownerStartingPoint;
        Time = time;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public String getOwnerDestination() {
        return OwnerDestination;
    }

    public String getOwnerStartingPoint() {
        return OwnerStartingPoint;
    }

    public String getTime() {
        return Time;
    }
}
