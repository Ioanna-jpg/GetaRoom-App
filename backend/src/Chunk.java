
import java.io.Serializable;
import java.time.ZoneOffset;
import java.util.ArrayList;
//test

public class Chunk implements Serializable{
    /* Chunk must implement Serializable in order to pass it in stream */

    /*
     * typeId :
     *  1 -> segment
     *  2 -> file
     */
    private int typeId;
    private int segmentId;
    private ArrayList<Room> rooms;
    private room


    private int number;
    private int fileId;
    private int userId;
    private int key;


    //test
    //test

    // Output of mapper
    // results: [totalDistance, totalTimeInHours, averageSpeed, totalElevation]

    public Chunk(int typeId, int key, int num, int userId, int fileId)
    {
        this.typeId = typeId;
        // Keep the number and id of user
        this.key = key;
        this.userId = userId;
        this.fileId = fileId;
        this.number = num;


        ls_wpt = new ArrayList<Waypoint>();
    }

    public Chunk(Chunk other) {
        this.ls_wpt = other.ls_wpt;
        this.key = other.key;
        this.number = other.getNum();
        this.fileId = other.getFileId();
        this.userId = other.getUserId();
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getFileId() {
        return this.fileId;
    }

    public int getNum() {
        return this.number;
    }

    public void add(Waypoint wpt)
    {
        this.ls_wpt.add(wpt);
    }

    public int size() {
        return this.ls_wpt.size();
    }

    public Waypoint get(int i) {
        return ls_wpt.get(i);
    }


    public String toString() {
        return "Chunk Number: " + this.number + ", user id : " + this.userId + ", size : " + this.ls_wpt.size() + ", file id : " + this.fileId + " . ";
    }
}
