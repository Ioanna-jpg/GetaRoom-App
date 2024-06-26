package org.example;
import java.io.Serializable;


public class Room implements Serializable {

    private String roomName;
    private int noOfPersons;
    private String area;
    private int stars;
    private int noOfReviews;
    private String roomImage;

    private String id;

    public Room(String id, String roomName) {
        this.id = id;
        this.roomName = roomName;
    }

    // Getters and setters


    public Room(){

    }
    public Room(String roomName, int noOfPersons, String area, int stars, int noOfReviews, String roomImage)
    {

        this.roomName = roomName;
        this.noOfPersons = noOfPersons;
        this.area = area;
        this.stars = stars;
        this.noOfReviews = noOfReviews;
        this.roomImage = roomImage;
    }


    public String getRoomName() {
        return roomName;
    }
    public int getNoOfPersons() {
        return noOfPersons;
    }
    public String getArea() {
        return area;
    }
    public int getStars() {
        return stars;
    }
    public int getNoOfReviews(){
        return noOfReviews;
    }
    public String getRoomImage() {
        return roomImage;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setNoOfPersons(int noOfPersons) {
        this.noOfPersons = noOfPersons;
    }

    public void setNoOfReviews(int noOfReviews) {
        this.noOfReviews = noOfReviews;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }


    @Override
    public String toString()
    {
        return "roomName: " + this.roomName +
                " noOfPersons: " + this.noOfPersons +
                " area: " + this.area +
                " stars: " + this.stars +
                " noOfReviews: " + this.noOfReviews +
                " roomImage: " + this.roomImage;
    }
}

