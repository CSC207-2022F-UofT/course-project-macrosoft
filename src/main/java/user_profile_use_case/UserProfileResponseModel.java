package user_profile_use_case;

/**
 * This class is the response model of the user profile.
 */
public class UserProfileResponseModel {
    private final String firstName;
    private final String lastName;
    private String email;

    /**
     * Constructor for UserProfileResponseModel
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     */
    public UserProfileResponseModel(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
