import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.StringReader;




public class ManagerConsole {
   public static void main(String[] args) throws IOException {
    
     String filepath= "/Users/pckiousis/Desktop/App_forRoom_Man/App_forRoom_Man";
     JSONParser parser = new JSONParser();
        
        try {
            
            String content = new String(Files.readAllBytes(Paths.get(filepath)), StandardCharsets.UTF_8);
            StringReader reader = new StringReader(content);
            Object obj = parser.parse(reader);
            JSONArray array = (JSONArray) obj;
            String jsonText = array.toString();
           
            ManagerConsole console = new ManagerConsole();
            console.sendAccommodationDetails("masterHostAddress", 8380, jsonText); // Replace with actual host and port
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            e.printStackTrace();
          } 
           
   }
     public void sendAccommodationDetails(String host, int port, String accommodationDetails) {
        try (Socket socket = new Socket(host, port);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {

            // Αποστολή των στοιχείων του καταλύματος
            outputStream.writeUTF(accommodationDetails);
            outputStream.flush();
            
            System.out.println("Room details sent to master successfully.");

        } catch (UnknownHostException e) {
            System.err.println("Host not found: " + host);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Σφάλμα κατά την επικοινωνία με τον master στον host " + host + " στη θύρα " + port);
            e.printStackTrace();
        }
    }
 }
    
    