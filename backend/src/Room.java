import java.time.LocalDateTime;
import java.io.*;

public class Room implements Serializable {

    private String roomName;
    private int noOfPersons;
    private String area;
    private int stars;
    private int noOfReviews;
    private String roomImage;

    private String id;
    private List<Reservation> reservations;

    public Room(String id, String roomName) {
        this.id = id;
        this.roomName = roomName;
        this.reservations = new ArrayList<>();
    }

    public synchronized void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public synchronized List<Reservation> getReservations() {
        return new ArrayList<>(reservations); // Return a copy to avoid concurrent modification
    }

        // Getters and setters
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

public class Reservation {
    private String id;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(String id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters
}