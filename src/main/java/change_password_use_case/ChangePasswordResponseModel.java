package change_password_use_case;

// Use case layer

public class ChangePasswordResponseModel {
    private String message;

    public ChangePasswordResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
