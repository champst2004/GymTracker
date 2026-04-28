package model;

public class QuarterlySubscription extends Subscription {

    public QuarterlySubscription() {
        super();
        this.setSubscriptionType("Quarterly");
        this.setAmount(calculateCost());
    }

    public QuarterlySubscription(int subscriptionId, int memberId, String startDate, String endDate, String status) {
        super(subscriptionId, memberId, "Quarterly", startDate, endDate, 0.0, status);
        this.setAmount(calculateCost());
    }

    @Override
    public double calculateCost() {
        return 2699.0;
    }
}
