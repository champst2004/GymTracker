package model;

/**
 * @author GymTracker
 * @version 1.0
 */
public abstract class Person {
    private String name;
    private String phone;
    private String email;

    /**
     * Parameterized constructor for Person.
     * @param name The person's name
     * @param phone The person's phone number
     * @param email The person's email address
     */
    public Person(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /** Default constructor */
    public Person() {}

    /**
     * @return The specific role of the person (Member, Trainer, etc.)
     */
    public abstract String getRole();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', phone='" + phone + "', email='" + email + "'}";
    }
}
