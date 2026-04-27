package dao;

import model.Member;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    /**
     * Adds a new member to the database.
     * 
     * @param m The Member object
     * @return true if successful, false otherwise
     */
    public boolean addMember(Member m) {
        String sql = "INSERT INTO members (name, phone, email, weight, gender, join_date, trainer_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getName());
            stmt.setString(2, m.getPhone());
            stmt.setString(3, m.getEmail());
            stmt.setDouble(4, m.getWeight());
            stmt.setString(5, m.getGender());
            stmt.setString(6, m.getJoinDate());

            if (m.getTrainerId() > 0) {
                stmt.setInt(7, m.getTrainerId());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retrieves all members from the database, including trainer name.
     * 
     * @return List of Member objects
     */
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT m.*, t.name AS trainer_name FROM members m LEFT JOIN trainers t ON m.trainer_id = t.trainer_id";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Member m = new Member(
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getInt("member_id"),
                        rs.getDouble("weight"),
                        rs.getString("gender"),
                        rs.getString("join_date"),
                        rs.getInt("trainer_id"));
                m.setTrainerName(rs.getString("trainer_name"));
                members.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    /**
     * Retrieves a single member by ID.
     * 
     * @param id The member ID
     * @return Member object or null
     */
    public Member getMemberById(int id) {
        String sql = "SELECT m.*, t.name AS trainer_name FROM members m LEFT JOIN trainers t ON m.trainer_id = t.trainer_id WHERE m.member_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Member m = new Member(
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getInt("member_id"),
                            rs.getDouble("weight"),
                            rs.getString("gender"),
                            rs.getString("join_date"),
                            rs.getInt("trainer_id"));
                    m.setTrainerName(rs.getString("trainer_name"));
                    return m;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Updates an existing member.
     * 
     * @param m The Member object
     * @return true if successful
     */
    public boolean updateMember(Member m) {
        String sql = "UPDATE members SET name=?, phone=?, email=?, weight=?, gender=?, join_date=?, trainer_id=? WHERE member_id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getName());
            stmt.setString(2, m.getPhone());
            stmt.setString(3, m.getEmail());
            stmt.setDouble(4, m.getWeight());
            stmt.setString(5, m.getGender());
            stmt.setString(6, m.getJoinDate());

            if (m.getTrainerId() > 0) {
                stmt.setInt(7, m.getTrainerId());
            } else {
                stmt.setNull(7, java.sql.Types.INTEGER);
            }
            stmt.setInt(8, m.getMemberId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Deletes a member.
     * 
     * @param id The member ID
     * @return true if successful
     */
    public boolean deleteMember(int id) {
        String sql = "DELETE FROM members WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Assigns a trainer to a member.
     * 
     * @param memberId  member ID
     * @param trainerId trainer ID
     * @return true if successful
     */
    public boolean assignTrainer(int memberId, int trainerId) {
        String sql = "UPDATE members SET trainer_id = ? WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, trainerId);
            stmt.setInt(2, memberId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Removes trainer from a member.
     * 
     * @param memberId The member ID
     * @return true if successful
     */
    public boolean removeTrainer(int memberId) {
        String sql = "UPDATE members SET trainer_id = NULL WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, memberId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
