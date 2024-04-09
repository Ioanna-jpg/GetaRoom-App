package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
public class Master {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Master().openServer();

    }
    ServerSocket providerSocket;
    Socket connection = null;
    List<WorkerHandler> workers = new ArrayList<>();

    //N = number of workers
    public static int NUM_WORKERS = 5;
    public static String WORKER_HOST = "127.0.0.1";
    public static int WORKER_PORT = 9753;

    void openServer() {
        try {
            providerSocket = new ServerSocket(4321, 10);

            // Establish connections with worker nodes
            for (int i = 0; i < NUM_WORKERS; i++) {
                Socket workerSocket = new Socket(WORKER_HOST, WORKER_PORT);
                WorkerHandler workerHandler = new WorkerHandler(workerSocket);
                workers.add(workerHandler);
            }
            while (true) {
                connection = providerSocket.accept();

                ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
                String command = (String) in.readObject();
                if ("add_accommodation".equals(command)) {
                    String jsonRoom = (String) in.readObject();
                    List<Room> rooms = parseJsonRooms(jsonRoom);
                    distributeRooms(rooms, workers);
                }
                connection.close(); // Close the connection after handling the command

                //Thread t = new ActionsForUsers(connection);
                //t.start();

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }






    private List<Room> parseJsonRooms(String jsonRooms) {
        List<Room> roomsList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonRooms);
        JSONArray roomsArray = jsonObject.getJSONArray("rooms");

        for (int i = 0; i < roomsArray.length(); i++) {
            JSONObject roomObject = roomsArray.getJSONObject(i);
            Room room = new Room();
            room.setRoomName(roomObject.getString("roomName"));
            room.setNoOfPersons(roomObject.getInt("noOfPersons"));
            room.setArea(roomObject.getString("area"));
            room.setStars(roomObject.getInt("stars"));
            room.setNoOfReviews(roomObject.getInt("noOfReviews"));
            room.setRoomImage(roomObject.getString("roomImage"));
            roomsList.add(room);
        }
        return roomsList;
    }


    private void distributeRooms(List<Room> rooms, List<WorkerHandler> workers) throws IOException {
        for (Room room : rooms) {
            int workerIndex = hash(room, NUM_WORKERS) % workers.size();
            WorkerHandler worker = workers.get(workerIndex);
            worker.sendRoom(room);
        }
    }

    private int hash(Room room, int numberOfNodes) {
        // Compute the hash value based on the roomName
        String roomName = room.getRoomName();
        int hashValue = roomName.hashCode();

        // Ensure the hash value is non-negative
        hashValue = Math.abs(hashValue);

        // Calculate the node ID based on the hash value and the number of nodes
        int nodeId = hashValue % numberOfNodes;

        return nodeId;
    }


}
