import java.net.*;
import java.io.*;

public class Worker implements Runnable {
    private ServerSocket serverSocket;

    public Worker(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        System.out.println("Worker running on port " + serverSocket.getLocalPort());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket clientSocket = serverSocket.accept();
                handleClientRequest(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleClientRequest(Socket clientSocket) {
        // Handle the request from the master server
    }

    // ... Other methods
}
