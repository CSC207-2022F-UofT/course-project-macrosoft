package login_use_case;

/**
 * This class is the request model for the user login use case.
 */
public class UserLoginRequestModel {
    private String username;
    private String password;

    /**
     * Constructor for UserLoginRequestModel
     *
     * @param username the username
     * @param password the password
     */
    public UserLoginRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Get the username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
