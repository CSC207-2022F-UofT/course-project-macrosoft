package login_use_case;

import org.bson.types.ObjectId;

public class UserLoginResponseModel {
    private int responseCode;
    private String name;
    private ObjectId userId;

    public UserLoginResponseModel(int responseCode, String name, ObjectId userId) {
        this.responseCode = responseCode;
        this.name = name;
        this.userId = userId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
