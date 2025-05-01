package AMS;

public class Carrier {
    public int carrierId;
    public String carrierName;
    public int discount30Days;
    public int discount60Days;
    public int discount90Days;
    public int bulkBookingDiscount;
    public int refund2DaysBefore;
    public int refund10DaysBefore;
    public int refund20DaysBefore;
    public int silverUserDiscount;
    public int goldUserDiscount;
    public int platinumUserDiscount;

    public Carrier(int carrierId, String carrierName, int discount30Days, int discount60Days, int discount90Days,
                   int bulkBookingDiscount, int refund2DaysBefore, int refund10DaysBefore, int refund20DaysBefore,
                   int silverUserDiscount, int goldUserDiscount, int platinumUserDiscount) {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.discount30Days = discount30Days;
        this.discount60Days = discount60Days;
        this.discount90Days = discount90Days;
        this.bulkBookingDiscount = bulkBookingDiscount;
        this.refund2DaysBefore = refund2DaysBefore;
        this.refund10DaysBefore = refund10DaysBefore;
        this.refund20DaysBefore = refund20DaysBefore;
        this.silverUserDiscount = silverUserDiscount;
        this.goldUserDiscount = goldUserDiscount;
        this.platinumUserDiscount = platinumUserDiscount;
    }

    public int getCarrierId() {
        return carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public int getDiscount30Days() {
        return discount30Days;
    }

    public int getDiscount60Days() {
        return discount60Days;
    }

    public int getDiscount90Days() {
        return discount90Days;
    }

    public int getBulkBookingDiscount() {
        return bulkBookingDiscount;
    }

    public int getRefund2DaysBefore() {
        return refund2DaysBefore;
    }

    public int getRefund10DaysBefore() {
        return refund10DaysBefore;
    }

    public int getRefund20DaysBefore() {
        return refund20DaysBefore;
    }

    public int getSilverUserDiscount() {
        return silverUserDiscount;
    }

    public int getGoldUserDiscount() {
        return goldUserDiscount;
    }

    public int getPlatinumUserDiscount() {
        return platinumUserDiscount;
    }

    public void displayCarrierDetails() {
        System.out.println("CarrierID : " + carrierId);
        System.out.println("CarrierName : " + carrierName);
        System.out.println("DiscountPercentageThirtyDaysAdvanceBooking : " + discount30Days);
        System.out.println("DiscountPercentageSixtyDaysAdvanceBooking : " + discount60Days);
        System.out.println("DiscountPercentageNinteyDaysAdvanceBooking : " + discount90Days);
        System.out.println("BulkBookingDiscount : " + bulkBookingDiscount);
        System.out.println("RefundPercentageForTicketCancellation2DaysBeforeTravelDate : " + refund2DaysBefore);
        System.out.println("RefundPercentageForTicketCancellation10DaysBeforeTravelDate : " + refund10DaysBefore);
        System.out.println("RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate : " + refund20DaysBefore);
        System.out.println("SilverUserDiscount : " + silverUserDiscount);
        System.out.println("GoldUserDiscount : " + goldUserDiscount);
        System.out.println("PlatinumUserDiscount : " + platinumUserDiscount);
    }
}
