package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public abstract class Subscription {
    private int subscriptionId;
    private int memberId;
    private String memberName; // Added for display joins
    private String subscriptionType;
    private String startDate;
    private String endDate;
    private double amount;
    private String status;

    /**
     * Default constructor for Subscription.
     */
    public Subscription() {
        this.status = "Active";
    }

    /**
     * Parameterized constructor for Subscription.
     * @param subscriptionId The unique subscription ID
     * @param memberId The ID of the member subscribing
     * @param subscriptionType The type of subscription
     * @param startDate The start date
     * @param endDate The end date
     * @param amount The cost
     * @param status The status (Active/Expired/Cancelled)
     */
    public Subscription(int subscriptionId, int memberId, String subscriptionType, String startDate, String endDate, double amount, String status) {
        this.subscriptionId = subscriptionId;
        this.memberId = memberId;
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.status = status;
    }

    /**
     * Calculates the cost based on the specific type of subscription.
     * @return Cost amount
     */
    public abstract double calculateCost();

    /**
     * Returns a string summary of the subscription using calculateCost.
     * @return Summary string
     */
    public String getSummary() {
        return "Type: " + subscriptionType + " | Cost: ₹" + calculateCost() + " | Status: " + status;
    }

    /**
     * @return the subscriptionId
     */
    public int getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * @param subscriptionId the subscriptionId to set
     */
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the subscriptionType
     */
    public String getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * @param subscriptionType the subscriptionType to set
     */
    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
