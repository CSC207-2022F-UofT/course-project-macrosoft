package DataModels;

import org.bson.types.ObjectId;

public class UserGetOrderRequestModel {
    private ObjectId userId;

    public UserGetOrderRequestModel(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
