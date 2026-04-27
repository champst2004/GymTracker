package dao;

import model.Attendance;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    /**
     * Marks attendance.
     * @param a Attendance object
     * @return true if successful
     */
    public boolean markAttendance(Attendance a) {
        String sql = "INSERT INTO attendance (member_id) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, a.getMemberId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Gets attendance by member with member name.
     * @param memberId member ID
     * @return list of Attendance
     */
    public List<Attendance> getAttendanceByMember(int memberId) {
        List<Attendance> attendances = new ArrayList<>();
        String sql = "SELECT a.*, m.name AS member_name FROM attendance a JOIN members m ON a.member_id = m.member_id WHERE a.member_id = ? ORDER BY a.check_in_time DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, memberId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    attendances.add(new Attendance(
                            rs.getInt("attendance_id"),
                            rs.getInt("member_id"),
                            rs.getString("member_name"),
                            rs.getString("check_in_time")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }

    /**
     * Gets all attendances joined with member name.
     * @return list of Attendance
     */
    public List<Attendance> getAllAttendance() {
        List<Attendance> attendances = new ArrayList<>();
        String sql = "SELECT a.*, m.name AS member_name FROM attendance a JOIN members m ON a.member_id = m.member_id ORDER BY a.check_in_time DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                attendances.add(new Attendance(
                        rs.getInt("attendance_id"),
                        rs.getInt("member_id"),
                        rs.getString("member_name"),
                        rs.getString("check_in_time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendances;
    }
}
