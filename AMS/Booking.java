package AMS;

import java.util.Date;

public class Booking {
    public int bookingId;
    public int userId;
    public String flightId;
    public Date bookingDate;
    public Date travelDate;
    public double totalAmount;

    public Booking(int bookingId, int userId, String flightId, Date bookingDate, Date travelDate, double totalAmount) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.flightId = flightId;
        this.bookingDate = bookingDate;
        this.travelDate = travelDate;
        this.totalAmount = totalAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public String getFlightId() {
        return flightId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
