package AMS;

//import java.util.HashMap;
//import java.util.Map;
import java.util.*;

public class Main {

    // Simulated database for customer credentials
//    private static HashMap<String, String> customerDatabase = new HashMap<>();
//    public static Map<Integer, Customer> registeredCustomers = new HashMap<>();


    private static final String ADMIN_USERID = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
//        customerDatabase.put("john_doe", "pass123");

        System.out.println("=== Airline Management System - AMS ===");
        System.out.println("1. Admin Sign-in");
        System.out.println("2. Customer Sign-in");
        System.out.println("3. Customer Registration");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter User ID: ");
                String adminId = scanner.nextLine();
                System.out.print("Enter Password: ");
                String adminPwd = scanner.nextLine();

                if (adminSignIn(adminId, adminPwd)) {
                    System.out.println("Admin signed in successfully!");
                    AdminService.showAdminMenu(); // Admin menu
                } else {
                    System.out.println("Invalid Admin credentials.");
                    Main.main(null);
                }
                break;

            case 2:
                System.out.print("Enter User ID: ");
                int customerId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Password: ");
                String customerPwd = scanner.nextLine();

                if (customerSignIn(customerId, customerPwd)) {
                    System.out.println("Customer signed in successfully!");
                    CustomerService.start(); // Customer menu
                } else {
                    System.out.println("Invalid Customer credentials.");
                    Main.main(null);
                }
                break;

            case 3:
                CustomerService.registerCustomer(); // Only register, no menu
                break;

            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private static boolean adminSignIn(String userId, String password) {
        return ADMIN_USERID.equals(userId) && ADMIN_PASSWORD.equals(password);
    }

    private static boolean customerSignIn(int userId, String password) {
        return CustomerService.customerDatabase.containsKey(userId) && CustomerService.customerDatabase.get(userId).equals(password);
    }
    
}

// q1
//public class Main {
//
//	// Simulated database for customers (userId -> password)
//    private static HashMap<String, String> customerDatabase = new HashMap<>();
//
//    // Default admin credentials
//    private static final String ADMIN_USERID = "admin";
//    private static final String ADMIN_PASSWORD = "admin123";
//
//    public static void main(String[] args) {
//        // Preload a customer user into the database
//        customerDatabase.put("john_doe", "pass123");
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("=== Airline Management System - AMS ===");
//        System.out.println("1. Admin Sign-in");
//        System.out.println("2. Customer Sign-in");
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//        
//        if(choice != 1 && choice != 2) {
//            System.out.println("Invalid choice. Please enter 1 or 2.");
//            scanner.close();
//            return;
//        }
//
//        System.out.print("Enter User ID: ");
//        String userId = scanner.nextLine();
//
//        System.out.print("Enter Password: ");
//        String password = scanner.nextLine();
//
//        switch (choice) {
//            case 1:
//                if (adminSignIn(userId, password)) {
//                    System.out.println("Admin signed in successfully!");
//                    AdminService.showAdminMenu();
//                    // Proceed to admin menu
//                } else {
//                    System.out.println("Invalid Admin credentials.");
//                }
//                break;
//
//            case 2:
//                if (customerSignIn(userId, password)) {
//                    System.out.println("Customer signed in successfully!");
//                    // Proceed to customer menu
//                } else {
//                    System.out.println("Invalid Customer credentials.");
//                }
//                break;
//
//            
//        }
//
//        scanner.close();
//    }
//
//    private static boolean adminSignIn(String userId, String password) {
//        return ADMIN_USERID.equals(userId) && ADMIN_PASSWORD.equals(password);
//    }
//
//    private static boolean customerSignIn(String userId, String password) {
//        return customerDatabase.containsKey(userId) && customerDatabase.get(userId).equals(password);
//    }
//
// }