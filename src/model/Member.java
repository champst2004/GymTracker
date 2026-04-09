package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public class Member extends Person {
    private int memberId;
    private double weight;
    private String gender;
    private String joinDate;
    private int trainerId;
    private String trainerName; // Added for display joins

    /** Default constructor */
    public Member() {
        super();
        this.trainerId = 0;
    }

    /**
     * Parameterized constructor for Member.
     * @param name The member's name
     * @param phone The member's phone number
     * @param email The member's email address
     * @param memberId The unique member ID
     * @param weight The member's weight
     * @param gender The member's gender
     * @param joinDate The member's joining date
     * @param trainerId The assigned trainer's ID
     */
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

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the joinDate
     */
    public String getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
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
     * @return the trainerName
     */
    public String getTrainerName() {
        return trainerName;
    }

    /**
     * @param trainerName the trainerName to set
     */
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
