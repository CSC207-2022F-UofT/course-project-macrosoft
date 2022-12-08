package entities;

import org.bson.types.ObjectId;

/**
 * This class is the user entity.
 */
public class User {
    private final String firstName;
    private final String lastName;
    private String email;
    private ObjectId userId;
    private final boolean verified;

    /**
     * Constructor for User
     *
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     * @param email     the email of the user
     * @param userId    the user id
     * @param verified  the verification status of the user
     */
    public User(String firstName, String lastName, String email, ObjectId userId, boolean verified) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.verified = verified;
    }

    /**
     * Gets the first name of the user
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the user
     *
     * @return the last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the email of the user
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user
     *
     * @param email the email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the user id
     *
     * @return the user id
     */
    public ObjectId getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     *
     * @param userId the user id
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * Gets the verification status of the user
     *
     * @return the verification status of the user
     */
    public boolean isVerified() {
        return verified;
    }
}
