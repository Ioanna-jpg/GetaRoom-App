import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import org.json.simple.*;

/* 
public class ManagerConsole {
   

        public static ArrayList<Room> readAccommodationFromJson(InputStream filePath) throws IOException {
            
            
            
        }
        public static void sendAccommodationInfoToMaster(Room room) {
            String masterHostName = "Master"; // Adjust this to your Master's hostname
            int masterPort = 8355; // Adjust this to your Master's listening port
    
            try (Socket socket = new Socket(masterHostName, masterPort);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                
                String response = in.readLine(); // Read response from master
                System.out.println("Response from Master: " + response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    
        public static void main(String[] args) {
            String filePath = "/Users/pckiousis/Desktop/aueb/6th semester/ds/ds_project/GetaRoom-App-main 2/backend/data"; // Adjust this to your JSON file's path
            try {
              ArrayList<Room> accommodation = readAccommodationFromJson(filePath);
                sendAccommodationInfoToMaster(accommodation);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // The sendAccommodationInfoToMaster method will be implemented in the next step.
    

}
*/