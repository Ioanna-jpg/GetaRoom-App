public class MasterServer {
    private int port;
    private ServerSocket serverSocket;
    private final List<WorkerHandler> workers = new ArrayList<>();

    public MasterServer(int port) {
        this.port = port;
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

    // Inner class to handle worker connections
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
