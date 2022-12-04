package login_use_case;

import org.bson.types.ObjectId;

public class UserLoginResponseModel {
    private int responseCode;
    private ObjectId userId;

    public UserLoginResponseModel(int responseCode, ObjectId userId) {
        this.responseCode = responseCode;
        this.userId = userId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
