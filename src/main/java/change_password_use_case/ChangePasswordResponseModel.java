package change_password_use_case;

// Use case layer

/**
 * This class is the response model for the change password use case.
 */
public class ChangePasswordResponseModel {
    private String message;

    /**
     * Constructor for ChangePasswordResponseModel
     *
     * @param message the message to be displayed
     */
    public ChangePasswordResponseModel(String message) {
        this.message = message;
    }

    /**
     * Gets the message
     *
     * @return String the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
