package AMS;

public class Flight {
    public String flightId;
    public String carrierName;
    public double ticketPrice;
    public int passengerCount;

    public Flight(String flightId, String carrierName, double ticketPrice, int passengerCount) {
        this.flightId = flightId;
        this.carrierName = carrierName;
        this.ticketPrice = ticketPrice;
        this.passengerCount = passengerCount;
    }

    public void display() {
        System.out.println("Flight ID: " + flightId);
        System.out.println("Carrier Name: " + carrierName);
        System.out.println("Ticket Price: $" + ticketPrice);
        System.out.println("Passenger Count: " + passengerCount);
    }
}

