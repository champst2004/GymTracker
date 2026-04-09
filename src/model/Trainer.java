package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public class Trainer extends Person {
    private int trainerId;
    private String specialization;

    /** Default constructor */
    public Trainer() {
        super();
    }

    /**
     * Parameterized constructor for Trainer.
     * @param name The trainer's name
     * @param phone The trainer's phone number
     * @param email The trainer's email address
     * @param trainerId The unique trainer ID
     * @param specialization The trainer's specialization
     */
    public Trainer(String name, String phone, String email, int trainerId, String specialization) {
        super(name, phone, email);
        this.trainerId = trainerId;
        this.specialization = specialization;
    }

    @Override
    public String getRole() {
        return "Trainer";
    }

    /**
     * @return the trainerId
     */
    public int getTrainerId() {
        return trainerId;
    }

    /**
     * @param trainerId the trainerId to set
     */
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
