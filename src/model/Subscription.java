package model;

public abstract class Subscription {
    private int subscriptionId;
    private int memberId;
    private String memberName;
    private String subscriptionType;
    private String startDate;
    private String endDate;
    private double amount;
    private String status;

    public Subscription() {
        this.status = "Active";
    }

    public Subscription(int subscriptionId, int memberId, String subscriptionType, String startDate, String endDate, double amount, String status) {
        this.subscriptionId = subscriptionId;
        this.memberId = memberId;
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.status = status;
    }

    public abstract double calculateCost();

    public String getSummary() {
        return "Type: " + subscriptionType + " | Cost: ₹" + calculateCost() + " | Status: " + status;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
