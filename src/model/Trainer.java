package model;

public class Trainer extends Person {
    private int trainerId;
    private String specialization;

    public Trainer() {
        super();
    }

    public Trainer(String name, String phone, String email, int trainerId, String specialization) {
        super(name, phone, email);
        this.trainerId = trainerId;
        this.specialization = specialization;
    }

    @Override
    public String getRole() {
        return "Trainer";
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getSpecialization() {
        return specialization;
    }

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
