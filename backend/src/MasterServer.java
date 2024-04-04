import java.io.*;
import java.net.*;
import java.util.*;


public class MasterServer {
    private ServerSocket serverSocket;
    private final int numberOfWorkers;
    private  ArrayList<Worker> workers;
    private List<Thread> workerThreads;
   
    
    public MasterServer(int numberOfWorkers, int start_port) throws IOException {
        //this.serverSocket = new ServerSocket(port);
        this.numberOfWorkers = numberOfWorkers;
        //this.workers = new ArrayList<>();
        
        workerThreads = new ArrayList<>();
        // Initialize workers
        for (int i = 0; i < numberOfWorkers; i++) {
            int port = start_port + i;
            Worker worker = new Worker(port);
            Thread workerThread = new Thread(worker);
            workerThreads.add(workerThread);
            workerThread.start();
        }
    }

    public void start() {
        System.out.println("Master Server is running...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket, this)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // Hash function that maps roomName to a worker node
    public int hashFunction(String roomName) {
        return roomName.hashCode() % numberOfWorkers;
    }

    // Dispatch the accommodation details to the appropriate worker
    public void dispatchToWorker(String accommodationDetails, String roomName) {
        int nodeId = hashFunction(roomName);
        Worker assignedWorker = workers.get(nodeId);
        assignedWorker.storeAccommodationDetails(accommodationDetails);
    }

    // Main method to start the server
    public static void main(String[] args) throws IOException {
        int port = 8380; // Set the port number
        int numberOfWorkers = 5; // Set the number of worker nodes
        MasterServer server = new MasterServer(port, numberOfWorkers);
        server.start();
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final MasterServer server;

    public ClientHandler(Socket socket, MasterServer server) {
        this.clientSocket = socket;
        this.server = server;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String accommodationDetails = in.readLine(); // Read the details sent by the manager
            String roomName = extractRoomName(accommodationDetails); // Implement this method based on your JSON parsing
            server.dispatchToWorker(accommodationDetails, roomName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Extract the room name from the accommodation details
    private String extractRoomName(String details) {
        // Implement JSON parsing here to extract the room name
        // Use the details you expect in the JSON string to parse and return the roomName
        return "";
    }
}

