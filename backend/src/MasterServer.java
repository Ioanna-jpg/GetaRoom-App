import java.io.*;
import java.util.ArrayList;



public class MasterServer {
    private int port;
    private ServerSocket serverSocket;
    private final List<WorkerHandler> workers = new ArrayList<>();
    ParserJSON jsonfile= new ParserJSON();
    public MasterServer(int port) {
        this.port = port;
    }
    public void main(String args[]){

        MasterServer masterobject=new MasterServer();
        InputStream stream= new InputStream(jsonfile);

        
    }
    










    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Master Server started on port " + port);

            while (true) {
                Socket workerSocket = serverSocket.accept();
                synchronized (workers) {
                    WorkerHandler workerHandler = new WorkerHandler(workerSocket);
                    workers.add(workerHandler);
                    new Thread(workerHandler).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     private static int hashFunction1(String area) {
       // hashing depending on the area key
        return area.hashCode();
    }


    
    public static int assignToNode1(String area, int numberOfNodes) {
        int nodeId = hashFunction1(area) % numberOfNodes;
        return nodeId;
    }
     private static int hashFunction2(int count ) {
       
        return count.hashCode();
    }

    
    public static int assignToNode2(int count, int numberOfNodes) {
        int nodeId = hashFunction2(count) % numberOfNodes;
        return nodeId;
    }
    private static int hashFunction3(int stars) {
       
        return stars.hashCode();
    }
    public static int assignToNode3(int stars, int numberOfNodes) {
        int nodeId = hashFunction2(stars) % numberOfNodes;
        return nodeId;
    }



    

    public static int assignToNode(String roomName, int numberOfNodes) {
        int nodeId = hashFunction(roomName) % numberOfNodes;
        return nodeId;
    }

  */
    
}



    private static class WorkerHandler implements Runnable {
        private Socket workerSocket;

        public WorkerHandler(Socket workerSocket) {
            this.workerSocket = workerSocket;
        }

        @Override
        public void run() {
            // Handle worker tasks
        }
    }
}
