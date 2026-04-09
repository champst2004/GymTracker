package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public class YearlySubscription extends Subscription {

    /** Default constructor */
    public YearlySubscription() {
        super();
        this.setSubscriptionType("Yearly");
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
    public YearlySubscription(int subscriptionId, int memberId, String startDate, String endDate, String status) {
        super(subscriptionId, memberId, "Yearly", startDate, endDate, 0.0, status);
        this.setAmount(calculateCost());
    }

    @Override
    public double calculateCost() {
        return 8999.0;
    }
}
