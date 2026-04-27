package model;

public class Member extends Person {
    private int memberId;
    private double weight;
    private String gender;
    private String joinDate;
    private int trainerId;
    private String trainerName;

    public Member() {
        super();
        this.trainerId = 0;
    }

    public Member(String name, String phone, String email, int memberId, double weight, String gender, String joinDate, int trainerId) {
        super(name, phone, email);
        this.memberId = memberId;
        this.weight = weight;
        this.gender = gender;
        this.joinDate = joinDate;
        this.trainerId = trainerId;
    }

    @Override
    public String getRole() {
        return "Member";
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", trainerId=" + trainerId +
                '}';
    }
}
