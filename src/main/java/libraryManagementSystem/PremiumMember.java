package libraryManagementSystem;

public class PremiumMember extends Member {
    private double discountRate;

    public PremiumMember(String id, String name, double discountRate) {
        super(id, name);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Premium discount rate: " + discountRate + "%";
    }
}
