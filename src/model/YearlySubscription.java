package model;

public class YearlySubscription extends Subscription {

    public YearlySubscription() {
        super();
        this.setSubscriptionType("Yearly");
        this.setAmount(calculateCost());
    }

    public YearlySubscription(int subscriptionId, int memberId, String startDate, String endDate, String status) {
        super(subscriptionId, memberId, "Yearly", startDate, endDate, 0.0, status);
        this.setAmount(calculateCost());
    }

    @Override
    public double calculateCost() {
        return 8999.0;
    }
}
