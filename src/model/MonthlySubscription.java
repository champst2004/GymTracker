package model;

public class MonthlySubscription extends Subscription {

    public MonthlySubscription() {
        super();
        this.setSubscriptionType("Monthly");
        this.setAmount(calculateCost());
    }

    public MonthlySubscription(int subscriptionId, int memberId, String startDate, String endDate, String status) {
        super(subscriptionId, memberId, "Monthly", startDate, endDate, 0.0, status);
        this.setAmount(calculateCost());
    }

    @Override
    public double calculateCost() {
        return 999.0;
    }
}
