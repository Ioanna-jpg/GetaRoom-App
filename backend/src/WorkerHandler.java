package org.example;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.ObjectInputStream;


public class WorkerHandler {


    private Socket workerSocket;
    private ObjectOutputStream out;

    private Room room;

    public WorkerHandler(Socket workerSocket) {
        this.workerSocket = workerSocket;
        try {
            // Initialize input and output streams
            out = new ObjectOutputStream(workerSocket.getOutputStream());
            in = new ObjectInputStream(workerSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other methods for handling communication with the worker node...
}

public class WorkerHandler extends Thread {
    private ObjectOutputStream out;

    public WorkerHandler(Socket workerSocket) {


    }
    // other variables and constructor

    public void sendRoom(Room room) throws IOException {
        out.writeObject(room);
        out.flush();
    }

    @Override
    public void run() {
        // Worker handling logic
    }
}
