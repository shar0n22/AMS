package AMS;

import java.text.SimpleDateFormat;
import java.util.*;

public class AdminService {
    private static final Scanner scanner = new Scanner(System.in);

    public static int carrierIdCounter = 1000;
    public static final Map<String, Flight> flightMap = new HashMap<>();
    public static final Map<Integer, Carrier> carrierMap = new HashMap<>();

    public static boolean adminSignIn(String userId, String password) {
        // Default admin credentials
        return userId.equals("admin") && password.equals("admin123");
    }

    public static void showAdminMenu() {
        int choice;
        do {
            System.out.println("\n--- AMS Admin Menu ---");
            System.out.println("1. Add Carrier Information");
            System.out.println("2. Edit/View Carrier Details by CarrierId");
            System.out.println("3. Remove Carrier by Id");
            System.out.println("4. Add Flight");
            System.out.println("5. Flight Cancellation - Refund Price Calculation");
            System.out.println("6. Exit AMS");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addCarrier();
                case 2 -> editCarrier();
                case 3 -> removeCarrier();
                case 4 -> addFlight();
                case 5 -> calculateTotalRefundForFlightCancellation();
                case 6 -> {
                    System.out.println("Exiting AMS...");
                    Main.main(null);
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addCarrier() {

        try {
            int carrierId = carrierIdCounter++;
            System.out.print("Enter Carrier Name: ");
            String carrierName = scanner.nextLine();

            System.out.print("Enter 30 Days Advance Booking Discount (%): ");
            int d30 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter 60 Days Advance Booking Discount (%): ");
            int d60 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter 90 Days Advance Booking Discount (%): ");
            int d90 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Bulk Booking Discount (%): ");
            int bulk = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Refund % for Cancellation 2 Days Before Travel: ");
            int r2 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Refund % for Cancellation 10 Days Before Travel: ");
            int r10 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Refund % for Cancellation 20+ Days Before Travel: ");
            int r20 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Silver User Discount (%): ");
            int silver = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Gold User Discount (%): ");
            int gold = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Platinum User Discount (%): ");
            int platinum = Integer.parseInt(scanner.nextLine());

            Carrier carrier = new Carrier(carrierId, carrierName, d30, d60, d90, bulk, r2, r10, r20, silver, gold,
                    platinum);
            carrierMap.put(carrierId, carrier);

            System.out.println("Carrier Information Saved Successfully in the System. Carrier ID: " + carrierId);
        } catch (Exception e) {
            System.out.println(
                    "Encountered issue while saving Carrier Information. Please check the data and try again.");
        }
        // System.out.print("Enter Flight ID: ");
        // String flightId = scanner.nextLine();
        // System.out.print("Enter Carrier Name: ");
        // String carrierName = scanner.nextLine();
        // System.out.print("Enter Ticket Price: ");
        // double ticketPrice = scanner.nextDouble();
        // System.out.print("Enter Passenger Count: ");
        // int passengerCount = scanner.nextInt();
        // scanner.nextLine(); // consume newline
        //
        // Flight flight = new Flight(flightId, carrierName, ticketPrice,
        // passengerCount);
        // flightMap.put(flightId, flight);
        // System.out.println("Carrier (Flight) added successfully.");
    }

    private static void editCarrier() {
        System.out.print("Enter Carrier ID to view/edit: ");
        int carrierId = Integer.parseInt(scanner.nextLine());

        Carrier carrier = carrierMap.get(carrierId);

        if (carrier == null) {
            System.out.println(
                    "Either the data is incorrect or no Carrier Information is available for the given Carrier ID");
            return;
        }

        // Display carrier info
        System.out.println("\nCarrier Information:");
        System.out.println("CarrierID : " + carrier.carrierId);
        System.out.println("CarrierName : " + carrier.carrierName);
        System.out.println("DiscountPercentageThirtyDaysAdvanceBooking : " + carrier.discount30Days);
        System.out.println("DiscountPercentageSixtyDaysAdvanceBooking : " + carrier.discount60Days);
        System.out.println("DiscountPercentageNinteyDaysAdvanceBooking : " + carrier.discount90Days);
        System.out.println("BulkBookingDiscount : " + carrier.bulkBookingDiscount);
        System.out.println("RefundPercentageForTicketCancellation2DaysBeforeTravelDate : " + carrier.refund2DaysBefore);
        System.out
                .println("RefundPercentageForTicketCancellation10DaysBeforeTravelDate : " + carrier.refund10DaysBefore);
        System.out.println(
                "RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate : " + carrier.refund20DaysBefore);
        System.out.println("SilverUserDiscount : " + carrier.silverUserDiscount);
        System.out.println("GoldUserDiscount : " + carrier.goldUserDiscount);
        System.out.println("PlatinumUserDiscount : " + carrier.platinumUserDiscount);

        System.out.print("\nDo you want to edit this carrier information? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (!response.equals("yes")) {
            return;
        }

        try {
            System.out.print("Enter New Carrier Name: ");
            carrier.carrierName = scanner.nextLine();

            System.out.print("Enter New 30 Days Advance Booking Discount (%): ");
            carrier.discount30Days = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New 60 Days Advance Booking Discount (%): ");
            carrier.discount60Days = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New 90 Days Advance Booking Discount (%): ");
            carrier.discount90Days = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Bulk Booking Discount (%): ");
            carrier.bulkBookingDiscount = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Refund % for Cancellation 2 Days Before Travel: ");
            carrier.refund2DaysBefore = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Refund % for Cancellation 10 Days Before Travel: ");
            carrier.refund10DaysBefore = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Refund % for Cancellation 20+ Days Before Travel: ");
            carrier.refund20DaysBefore = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Silver User Discount (%): ");
            carrier.silverUserDiscount = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Gold User Discount (%): ");
            carrier.goldUserDiscount = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Platinum User Discount (%): ");
            carrier.platinumUserDiscount = Integer.parseInt(scanner.nextLine());

            System.out.println("Carrier details updated successfully.");
        } catch (Exception e) {
            System.out.println("Error while updating carrier information. Please check your input and try again.");
        }
        // System.out.print("Enter Flight ID to edit: ");
        // String flightId = scanner.nextLine();
        //
        // if (flightMap.containsKey(flightId)) {
        // Flight flight = flightMap.get(flightId);
        // System.out.print("Enter New Carrier Name: ");
        // flight.carrierName = scanner.nextLine();
        // System.out.print("Enter New Ticket Price: ");
        // flight.ticketPrice = scanner.nextDouble();
        // System.out.print("Enter New Passenger Count: ");
        // flight.passengerCount = scanner.nextInt();
        // scanner.nextLine();
        // System.out.println("Carrier details updated successfully.");
        // } else {
        // System.out.println("Carrier with given ID not found.");
        // }
    }

    private static void removeCarrier() {
        System.out.print("Enter Carrier ID to remove: ");
        int carrierId = Integer.parseInt(scanner.nextLine());

        Carrier carrier = carrierMap.get(carrierId);

        if (carrier == null) {
            System.out.println(
                    "Either the data is incorrect or no Carrier Information is available for the given Carrier ID");
            return;
        }

        // Check for flights mapped to this carrier
        boolean hasMappedFlights = flightMap.values().stream()
                .anyMatch(flight -> flight.carrierId == carrierId);

        if (hasMappedFlights) {
            System.out.println("Remove All Flights Mapped to this Carrier before deleting this Carrier from system");
            return;
        }

        carrierMap.remove(carrierId);
        System.out.println("Carrier Information successfully removed from system");
    }

    private static void addFlight() {
        System.out.print("Enter Flight ID: ");
        String flightId = scanner.nextLine();

        System.out.print("Enter Carrier ID: ");
        int carrierId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Carrier Name: ");
        String carrierName = scanner.nextLine();

        System.out.print("Enter Ticket Price: ");
        double ticketPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter Passenger Count: ");
        int passengerCount = Integer.parseInt(scanner.nextLine());

        Flight flight = new Flight(flightId, carrierId, carrierName, ticketPrice, passengerCount);
        flightMap.put(flightId, flight);

        System.out.println("Flight added successfully.");
    }

    public static Flight getFlight(String flightId) {
        return flightMap.get(flightId);
    }

    // private static void calculateRefund() {
    // System.out.print("Enter Flight ID to calculate refund: ");
    // String flightId = scanner.nextLine();

    // if (flightMap.containsKey(flightId)) {
    // Flight flight = flightMap.get(flightId);
    // double refund = flight.ticketPrice * flight.passengerCount;
    // System.out.println("Total refund to customers: Rs " + refund);
    // System.out.println("Estimated loss to carrier: Rs" + refund);
    // } else {
    // System.out.println("Carrier with given ID not found.");
    // }
    // }

    public static void calculateTotalRefundForFlightCancellation() {
        System.out.print("Enter Flight ID: ");
        String flightId = scanner.nextLine();

        System.out.print("Enter Travel Date (dd-MM-yyyy): ");
        String travelDateInput = scanner.nextLine();
        Date travelDate;
        try {
            travelDate = new SimpleDateFormat("dd-MM-yyyy").parse(travelDateInput);
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }

        double totalRefund = 0;
        double totalCompensation = 0;
        Date today = new Date();

        boolean bookingsFound = false;

        for (Booking booking : CustomerService.allBookings) {
            if (booking.flightId.equals(flightId) &&
                    isSameDay(booking.travelDate, travelDate)) {

                bookingsFound = true;
                double refund = booking.totalAmount;

                long daysDiff = (booking.travelDate.getTime() - today.getTime()) / (1000 * 60 * 60 * 24);
                double compensation = (daysDiff < 7) ? refund * 0.10 : 0;

                totalRefund += refund;
                totalCompensation += compensation;
            }
        }

        if (!bookingsFound) {
            System.out.println("No bookings found for given Flight ID and Travel Date.");
            return;
        }

        double totalLoss = totalRefund + totalCompensation;

        System.out.println("\n--- Flight Cancellation Refund Summary ---");
        System.out.println("Total Refund to Customers: Rs " + totalRefund);
        if (totalCompensation > 0)
            System.out.println("Additional Compensation Paid: Rs " + totalCompensation);
        System.out.println("Total Loss to Carrier: Rs " + totalLoss);
        // if (flightMap.containsKey(flightId)) {
        // flightMap.remove(flightId);
        // System.out.println("Flight " + flightId + " has been removed from the system
        // due to cancellation.");
        // }
    }

    // Utility to compare two dates without time
    private static boolean isSameDay(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
                c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
    }

}