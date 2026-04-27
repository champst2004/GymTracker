package service;

import dao.SubscriptionDAO;
import model.*;

import java.util.List;

public class SubscriptionService {
    private SubscriptionDAO subscriptionDAO;

    public SubscriptionService() {
        this.subscriptionDAO = new SubscriptionDAO();
    }

    public boolean addSubscription(int memberId, String type, String startDate, String endDate) {
        Subscription s;
        switch (type) {
            case "Monthly":
                s = new MonthlySubscription();
                break;
            case "Quarterly":
                s = new QuarterlySubscription();
                break;
            case "Half-Yearly":
                s = new HalfYearlySubscription();
                break;
            case "Yearly":
                s = new YearlySubscription();
                break;
            default:
                return false;
        }
        s.setMemberId(memberId);
        s.setStartDate(startDate);
        s.setEndDate(endDate);
        s.setStatus("Active");

        return subscriptionDAO.addSubscription(s);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionDAO.getAllSubscriptions();
    }

    public List<Subscription> getSubscriptionsByMember(int memberId) {
        return subscriptionDAO.getSubscriptionsByMember(memberId);
    }
    
    public boolean updateStatus(int subscriptionId, String status) {
        return subscriptionDAO.updateStatus(subscriptionId, status);
    }
}
