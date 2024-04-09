package org.example;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;
public class DummyApplication {


    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private static Socket requestSocket;

    public static void main(String[] args) {

        try {
            // Connect to the Master server
            requestSocket = new Socket("localhost", 4321); // Use the correct IP and port
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            in = new ObjectInputStream(requestSocket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            int userType;

            // Επιλογή τύπου χρήστη
            System.out.println("Select user type:");
            System.out.println("1. Manager");
            System.out.println("2. Customer");
            System.out.print("Enter your choice: ");
            userType = scanner.nextInt();

            // Εμφάνιση μενού ανάλογα με τον τύπο χρήστη
            switch (userType) {
                case 1:
                    displayManagerMenu(scanner);
                    break;
                case 2:
                    displayCustomerMenu(scanner);
                    break;
                default:
                    System.out.println("Invalid user type.");
            }
        } catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            // Close connections
            try {
                in.close();
                out.close();
                requestSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }

    public static void displayManagerMenu(Scanner scanner) throws IOException {
        int choice;

        do {
            // Εμφάνιση μενού για τον διαχειριστή του καταλύματος
            System.out.println("\nManager Menu:");
            System.out.println("1. Add accomodation");
            System.out.println("2. Add available dates for rental");
            System.out.println("3. Display reservations");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // Εκτέλεση επιλογής χρήστη
            switch (choice) {
                case 1:
                    System.out.println("Adding accomodation...");

                    System.out.print("Enter the path of the JSON file for the accommodation: ");
                    String jsonFilePath = scanner.next();
                    File jsonFile = new File(jsonFilePath);

                    String jsonString = new String(Files.readAllBytes(jsonFile.toPath()), StandardCharsets.UTF_8);
                    out.writeObject("add_accommodation");
                    out.writeObject(jsonString);
                    out.flush();
                    break;
                case 2:
                    System.out.println("Adding available dates for rental...");
                    break;
                case 3:
                    System.out.println("Displaying reservations...");
                    break;
                case 4:
                    System.out.println("Loging out");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public static void displayCustomerMenu(Scanner scanner) {
        int choice;

        do {
            // Εμφάνιση μενού για τον πελάτη
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Filter accomodations");
            System.out.println("2. Book accomodation");
            System.out.println("3. Rank accomodation");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // Εκτέλεση επιλογής διαχειριστή
            switch (choice) {
                case 1:
                    System.out.println("Filtering accomodations...");
                    break;
                case 2:
                    System.out.println("Booking accomodation...");
                    break;
                case 3:
                    System.out.println("Ranking accomodation...");
                    break;
                case 4:
                    System.out.println("Loging out");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);


        // make display menu and customer menu methods check gpt4
    }
}
