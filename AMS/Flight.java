package AMS;

public class Flight {
    public String flightId;
    public int carrierId;
    public String carrierName;
    public double ticketPrice;
    public int passengerCount;

    public Flight(String flightId, int carrierId, String carrierName, double ticketPrice, int passengerCount) {
        this.flightId = flightId;
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.ticketPrice = ticketPrice;
        this.passengerCount = passengerCount;
    }
}