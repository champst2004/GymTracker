package model;

public class HalfYearlySubscription extends Subscription {

    /** Default constructor */
    public HalfYearlySubscription() {
        super();
        this.setSubscriptionType("Half-Yearly");
        this.setAmount(calculateCost());
    }

    public HalfYearlySubscription(int subscriptionId, int memberId, String startDate, String endDate, String status) {
        super(subscriptionId, memberId, "Half-Yearly", startDate, endDate, 0.0, status);
        this.setAmount(calculateCost());
    }

    @Override
    public double calculateCost() {
        return 4999.0;
    }
}
