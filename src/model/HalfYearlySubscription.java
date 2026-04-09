package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public class HalfYearlySubscription extends Subscription {

    /** Default constructor */
    public HalfYearlySubscription() {
        super();
        this.setSubscriptionType("Half-Yearly");
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
    public HalfYearlySubscription(int subscriptionId, int memberId, String startDate, String endDate, String status) {
        super(subscriptionId, memberId, "Half-Yearly", startDate, endDate, 0.0, status);
        this.setAmount(calculateCost());
    }

    @Override
    public double calculateCost() {
        return 4999.0;
    }
}
