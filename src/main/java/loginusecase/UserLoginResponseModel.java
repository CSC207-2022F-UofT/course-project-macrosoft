package loginusecase;

import entities.User;

public class UserLoginResponseModel {
    private int responseCode;
    private User user;

    public UserLoginResponseModel(int responseCode, User user) {
        this.responseCode = responseCode;
        this.user = user;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
