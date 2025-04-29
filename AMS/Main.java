package AMS;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // Simulated database for customers (userId -> password)
    private static HashMap<String, String> customerDatabase = new HashMap<>();

    // Default admin credentials
    private static final String ADMIN_USERID = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        // Preload a customer user into the database
        customerDatabase.put("john_doe", "pass123");

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Airline Management System - AMS ===");
        System.out.println("1. Admin Sign-in");
        System.out.println("2. Customer Sign-in");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please enter 1 or 2.");
            scanner.close();
            return;
        }

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        switch (choice) {
            case 1:
                if (adminSignIn(userId, password)) {
                    System.out.println("Admin signed in successfully!");
                    AdminService.showAdminMenu();
                    // Proceed to admin menu
                } else {
                    System.out.println("Invalid Admin credentials.");
                }
                break;

            case 2:
                if (customerSignIn(userId, password)) {
                    System.out.println("Customer signed in successfully!");
                    // Proceed to customer menu
                } else {
                    System.out.println("Invalid Customer credentials.");
                }
                break;

            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        scanner.close();
    }

    private static boolean adminSignIn(String userId, String password) {
        return ADMIN_USERID.equals(userId) && ADMIN_PASSWORD.equals(password);
    }

    private static boolean customerSignIn(String userId, String password) {
        return customerDatabase.containsKey(userId) && customerDatabase.get(userId).equals(password);
    }
}
