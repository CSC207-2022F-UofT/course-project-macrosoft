package change_user_info_use_case;

import org.bson.types.ObjectId;

public class ChangeUserInfoRequestModel {
    private ObjectId userId;
    private String newFirstName;
    private String newLastName;
    private String newEmail;

    public ChangeUserInfoRequestModel(ObjectId userId, String newFirstName, String newLastName, String newEmail) {
        this.userId = userId;
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
        this.newEmail = newEmail;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
