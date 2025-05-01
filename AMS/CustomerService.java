package AMS;

import java.util.*;
import java.text.SimpleDateFormat;

public class CustomerService {
    public static final Scanner scanner = new Scanner(System.in);
    public static int userIdCounter = 1000;
    public static Map<Integer, Customer> registeredCustomers = new HashMap<>();
    public static HashMap<Integer, String> customerDatabase = new HashMap<>();
    public static Map<Integer, Booking> bookings = new HashMap<>();
    public static int bookingIdCounter = 1000;
    public static List<Booking> allBookings = new ArrayList<>();

    public static void start() {
        // if (!customerSignIn()) {
        // System.out.println("Invalid credentials. Exiting.");
        // return;
        // }

        int choice;
        do {
            System.out.println("\n--- AMS Customer Menu ---");
            // System.out.println("1. Customer Registration");
            System.out.println("1. Edit Customer Profile");
            System.out.println("2. Ticket Booking - Price Calculation");
            System.out.println("3. Ticket Cancellation - Refund Calculation");
            System.out.println("4. Exit AMS");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                // case 1: registerCustomer(); break;
                case 1:
                    editCustomerProfile();
                    break;
                case 2:
                    calculateBookingAmount();
                    break;
                case 3:
                    cancelTicketAndCalculateRefund();
                    break;
                case 4:
                    System.out.println("Exiting AMS...");
                    Main.main(null);
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    public static boolean customerSignIn() {
        System.out.print("Enter Customer User ID (or press Enter to skip sign-in for now): ");
        String input = scanner.nextLine();
        return input.isEmpty() || true; // Simulated sign-in, update this logic when login is ready
    }

    public static void registerCustomer() {
        try {
            int userId = userIdCounter++;

            System.out.print("Enter User Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            System.out.print("Enter Phone: ");
            long phone = Long.parseLong(scanner.nextLine());
            System.out.print("Enter Email ID: ");
            String email = scanner.nextLine();
            System.out.print("Enter Address Line 1: ");
            String addr1 = scanner.nextLine();
            System.out.print("Enter Address Line 2: ");
            String addr2 = scanner.nextLine();
            System.out.print("Enter City: ");
            String city = scanner.nextLine();
            System.out.print("Enter State: ");
            String state = scanner.nextLine();
            System.out.print("Enter Country: ");
            String country = scanner.nextLine();
            System.out.print("Enter Zip Code: ");
            long zip = Long.parseLong(scanner.nextLine());
            System.out.print("Enter DOB (dd-MM-yyyy): ");
            String dobInput = scanner.nextLine();
            Date dob = new SimpleDateFormat("dd-MM-yyyy").parse(dobInput);

            Customer customer = new Customer(userId, name, password, phone, email,
                    addr1, addr2, city, state, country, zip, dob);

            registeredCustomers.put(userId, customer);
            customerDatabase.put(userId, password);

            System.out.println("Mapping: " + customerDatabase);

            System.out.println("Customer registered successfully. Your User ID is: " + userId);
            customer.displayProfile();
            Main.main(null);

        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }

    public static void editCustomerProfile() {
        System.out.print("Enter your User ID to edit profile: ");
        int userId = Integer.parseInt(scanner.nextLine());

        Customer customer = registeredCustomers.get(userId);
        if (customer == null) {
            System.out.println("No customer found with that User ID.");
            return;
        }

        try {
            System.out.print("Enter New User Name: ");
            customer.setUserName(scanner.nextLine());

            System.out.print("Enter New Password: ");
            customer.setPassword(scanner.nextLine());
            customerDatabase.put(userId, customer.getPassword());

            System.out.print("Enter New Phone: ");
            customer.setPhone(Long.parseLong(scanner.nextLine()));

            System.out.print("Enter New Email ID: ");
            customer.setEmail(scanner.nextLine());

            System.out.print("Enter New Address Line 1: ");
            customer.setAddress1(scanner.nextLine());

            System.out.print("Enter New Address Line 2: ");
            customer.setAddress2(scanner.nextLine());

            System.out.print("Enter New City: ");
            customer.setCity(scanner.nextLine());

            System.out.print("Enter New State: ");
            customer.setState(scanner.nextLine());

            System.out.print("Enter New Country: ");
            customer.setCountry(scanner.nextLine());

            System.out.print("Enter New Zip Code: ");
            customer.setZipCode(Long.parseLong(scanner.nextLine()));

            System.out.print("Enter New DOB (dd-MM-yyyy): ");
            String dobInput = scanner.nextLine();
            Date dob = new SimpleDateFormat("dd-MM-yyyy").parse(dobInput);
            customer.setDob(dob);

            System.out.println("Profile updated successfully.");

            customer.displayProfile();

            Main.main(null);

        } catch (Exception e) {
            System.out.println("Error during profile update: " + e.getMessage());
        }
    }

    public static void calculateBookingAmount() {
        try {
            System.out.print("Enter Flight ID: ");
            String flightId = scanner.nextLine();

            Flight flight = AdminService.getFlight(flightId);
            if (flight == null) {
                System.out.println("Flight not found.");
                return;
            }

            System.out.print("Enter your User ID: ");
            int userId = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Ticket Count: ");
            int ticketCount = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Seat Category (Economy/Business/Executive): ");
            String seatCategory = scanner.nextLine().toLowerCase();

            System.out.print("Enter Customer Category (Silver/Gold/Platinum): ");
            String customerCategory = scanner.nextLine().toLowerCase();

            System.out.print("Enter Travel Date (dd-MM-yyyy): ");
            String travelDateStr = scanner.nextLine();
            Date travelDate = new SimpleDateFormat("dd-MM-yyyy").parse(travelDateStr);
            Date today = new Date();

            long diffInDays = (travelDate.getTime() - today.getTime()) / (1000 * 60 * 60 * 24);

            double baseFare = flight.ticketPrice;
            double seatMultiplier = switch (seatCategory) {
                case "business" -> 2;
                case "executive" -> 5;
                default -> 1;
            };

            double totalAmount = baseFare * seatMultiplier * ticketCount;
            double discount = 0;

            // Booking time discount
            if (diffInDays >= 90)
                discount += 5;
            else if (diffInDays >= 60)
                discount += 3;
            else if (diffInDays >= 30)
                discount += 2;

            // Bulk booking
            if (ticketCount >= 10)
                discount += 2;

            // Customer category discount
            switch (customerCategory) {
                case "silver" -> discount += 1;
                case "gold" -> discount += 2;
                case "platinum" -> discount += 4;
            }

            double finalAmount = totalAmount * (1 - discount / 100);
            int bookingId = bookingIdCounter++;
            Date bookingDate = new Date(); // current date
            Booking booking = new Booking(bookingId, userId, flightId, bookingDate, travelDate, finalAmount);
            bookings.put(bookingId, booking);
            allBookings.add(booking);
            System.out.println("Booking successful! Your Booking ID is: " + bookingId);

            System.out.printf("Total Booking Amount after %.1f%% discount: Rs %.2f\n", discount, finalAmount);

        } catch (Exception e) {
            System.out.println("Error in booking calculation: " + e.getMessage());
        }
    }

    public static void cancelTicketAndCalculateRefund() {
        System.out.print("Enter your Booking ID: ");
        int bookingId = Integer.parseInt(scanner.nextLine());

        Booking booking = bookings.get(bookingId);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        Date today = new Date();
        long diffInMillies = booking.getTravelDate().getTime() - today.getTime();
        long diffDays = diffInMillies / (1000 * 60 * 60 * 24);

        double refundPercentage = 0;
        if (diffDays >= 20) {
            refundPercentage = 95;
        } else if (diffDays >= 10) {
            refundPercentage = 70;
        } else if (diffDays <= 2) {
            refundPercentage = 40;
        } else {
            refundPercentage = 0;
        }

        double refundAmount = booking.getTotalAmount() * (refundPercentage / 100);
        System.out.println("Refund Amount: Rs " + refundAmount);
        // allBookings.remove(booking);
        // System.out.println("Booking successfully cancelled and removed from
        // system.");
    }

}
