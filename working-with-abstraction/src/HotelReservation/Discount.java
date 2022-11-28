package HotelReservation;

public enum Discount {
    VIP(0.80),
    SECOND_VISIT(0.9),
    NONE(1);

    public double priceReductionFactor;

    Discount(double priceReductionFactor) {
        this.priceReductionFactor = priceReductionFactor;
    }

    public double getPriceReductionFactor() {
        return priceReductionFactor;
    }

    public static Discount parse(String discountType) {
        switch(discountType) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Invalid discount type");
        }
    }
}
