package AMS;

import java.util.*;

public class AdminService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Flight> flightMap = new HashMap<>();

    public static boolean adminSignIn(String userId, String password) {
        // Default admin credentials
        return userId.equals("admin") && password.equals("admin123");
    }

    public static void showAdminMenu() {
        int choice;
        do {
            System.out.println("\n--- AMS Admin Menu ---");
            System.out.println("1. Add Carrier");
            System.out.println("2. Edit Carrier Details by CarrierId");
            System.out.println("3. Remove Carrier by Id");
            System.out.println("4. Flight Cancellation - Refund Price Calculation");
            System.out.println("5. View All Flights");
            System.out.println("6. Exit AMS");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addCarrier();
                case 2 -> editCarrier();
                case 3 -> removeCarrier();
                case 4 -> calculateRefund();
                case 5 -> viewAllFlights();
                case 6 -> System.out.println("Exiting AMS...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addCarrier() {
        System.out.print("Enter Flight ID: ");
        String flightId = scanner.nextLine();
        System.out.print("Enter Carrier Name: ");
        String carrierName = scanner.nextLine();
        System.out.print("Enter Ticket Price: ");
        double ticketPrice = scanner.nextDouble();
        System.out.print("Enter Passenger Count: ");
        int passengerCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Flight flight = new Flight(flightId, carrierName, ticketPrice, passengerCount);
        flightMap.put(flightId, flight);
        System.out.println("Carrier (Flight) added successfully.");
    }

    private static void editCarrier() {
        System.out.print("Enter Flight ID to edit: ");
        String flightId = scanner.nextLine();

        if (flightMap.containsKey(flightId)) {
            Flight flight = flightMap.get(flightId);
            System.out.print("Enter New Carrier Name: ");
            flight.carrierName = scanner.nextLine();
            System.out.print("Enter New Ticket Price: ");
            flight.ticketPrice = scanner.nextDouble();
            System.out.print("Enter New Passenger Count: ");
            flight.passengerCount = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Carrier details updated successfully.");
        } else {
            System.out.println("Carrier with given ID not found.");
        }
    }

    private static void removeCarrier() {
        System.out.print("Enter Flight ID to remove: ");
        String flightId = scanner.nextLine();

        if (flightMap.remove(flightId) != null) {
            System.out.println("Carrier removed successfully.");
        } else {
            System.out.println("Carrier with given ID not found.");
        }
    }

    private static void calculateRefund() {
        System.out.print("Enter Flight ID to calculate refund: ");
        String flightId = scanner.nextLine();

        if (flightMap.containsKey(flightId)) {
            Flight flight = flightMap.get(flightId);
            double refund = flight.ticketPrice * flight.passengerCount;
            System.out.println("Total refund to customers: $" + refund);
            System.out.println("Estimated loss to carrier: $" + refund);
        } else {
            System.out.println("Carrier with given ID not found.");
        }
    }

    private static void viewAllFlights() {
        if (flightMap.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight flight : flightMap.values()) {
                flight.display(); // Assuming you have a display method in Flight class
            }
        }
    }
    
}

