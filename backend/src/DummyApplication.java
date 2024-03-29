import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import json;
public class DummyApplication {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Connect to Master Server
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter search criteria: ");
            String criteria = ParserJSON(/Users/pckiousis/Desktop/aueb/6th semester/ds/ds_project/GetaRoom-App-main 2/backend/data)
            output.writeObject(criteria); // Send criteria to Master Server

            // Receive and process response from Master Server
            // Example response handling

            output.close();
            input.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
