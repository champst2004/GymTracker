package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public class MonthlySubscription extends Subscription {

    /** Default constructor */
    public MonthlySubscription() {
        super();
        this.setSubscriptionType("Monthly");
        this.setAmount(calculateCost());
    }

    /**
     * Parameterized constructor.
     * @param subscriptionId The subscription ID
     * @param memberId The associated member ID
     * @param startDate The start date
     * @param endDate The end date
     * @param status The status
     */
    public MonthlySubscription(int subscriptionId, int memberId, String startDate, String endDate, String status) {
        super(subscriptionId, memberId, "Monthly", startDate, endDate, 0.0, status);
        this.setAmount(calculateCost());
    }

    @Override
    public double calculateCost() {
        return 999.0;
    }
}
