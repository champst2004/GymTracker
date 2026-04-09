package service;

import dao.TrainerDAO;
import model.Trainer;

import java.util.List;

/**
 * @author GymTracker
 * @version 1.0
 */
public class TrainerService {
    private TrainerDAO trainerDAO;

    public TrainerService() {
        this.trainerDAO = new TrainerDAO();
    }

    public boolean addTrainer(Trainer t) {
        return trainerDAO.addTrainer(t);
    }

    public List<Trainer> getAllTrainers() {
        return trainerDAO.getAllTrainers();
    }

    public Trainer getTrainerById(int id) {
        return trainerDAO.getTrainerById(id);
    }

    public boolean deleteTrainer(int id) {
        return trainerDAO.deleteTrainer(id);
    }
}
