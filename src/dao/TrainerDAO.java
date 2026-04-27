package dao;

import model.Trainer;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {

    /**
     * Adds a trainer.
     * @param t The trainer
     * @return true if successful
     */
    public boolean addTrainer(Trainer t) {
        String sql = "INSERT INTO trainers (name, phone, email, specialization) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getName());
            stmt.setString(2, t.getPhone());
            stmt.setString(3, t.getEmail());
            stmt.setString(4, t.getSpecialization());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Gets all trainers.
     * @return List of Trainers
     */
    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        String sql = "SELECT * FROM trainers";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                trainers.add(new Trainer(
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getInt("trainer_id"),
                        rs.getString("specialization")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainers;
    }

    /**
     * Gets trainer by id.
     * @param id Trainer ID
     * @return Trainer
     */
    public Trainer getTrainerById(int id) {
        String sql = "SELECT * FROM trainers WHERE trainer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Trainer(
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getInt("trainer_id"),
                            rs.getString("specialization")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deletes a trainer.
     * @param id Trainer ID
     * @return true if successful
     */
    public boolean deleteTrainer(int id) {
        String sql = "DELETE FROM trainers WHERE trainer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
