package dao;

import model.*;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {

    public boolean addSubscription(Subscription s) {
        String sql = "INSERT INTO subscriptions (member_id, subscription_type, start_date, end_date, amount, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getMemberId());
            stmt.setString(2, s.getSubscriptionType());
            stmt.setString(3, s.getStartDate());
            stmt.setString(4, s.getEndDate());
            stmt.setDouble(5, s.getAmount());
            stmt.setString(6, s.getStatus());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Subscription mapRowToSubscription(ResultSet rs) throws SQLException {
        int id = rs.getInt("subscription_id");
        int memberId = rs.getInt("member_id");
        String type = rs.getString("subscription_type");
        String start = rs.getString("start_date");
        String end = rs.getString("end_date");
        String status = rs.getString("status");

        Subscription sub;
        switch (type) {
            case "Monthly":
                sub = new MonthlySubscription(id, memberId, start, end, status);
                break;
            case "Quarterly":
                sub = new QuarterlySubscription(id, memberId, start, end, status);
                break;
            case "Half-Yearly":
                sub = new HalfYearlySubscription(id, memberId, start, end, status);
                break;
            case "Yearly":
                sub = new YearlySubscription(id, memberId, start, end, status);
                break;
            default:
                throw new SQLException("Unknown subscription type: " + type);
        }
        return sub;
    }

    public List<Subscription> getSubscriptionsByMember(int memberId) {
        List<Subscription> subs = new ArrayList<>();
        String sql = "SELECT * FROM subscriptions WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, memberId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    subs.add(mapRowToSubscription(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subs;
    }

    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subs = new ArrayList<>();
        String sql = "SELECT s.*, m.name AS member_name FROM subscriptions s JOIN members m ON s.member_id = m.member_id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Subscription sub = mapRowToSubscription(rs);
                sub.setMemberName(rs.getString("member_name"));
                subs.add(sub);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subs;
    }

    public boolean updateStatus(int subscriptionId, String status) {
        String sql = "UPDATE subscriptions SET status = ? WHERE subscription_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, subscriptionId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
