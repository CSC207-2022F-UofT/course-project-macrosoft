package user_profile_use_case;

import org.bson.types.ObjectId;

public class UserProfileRequestModel {
    private ObjectId userId;

    public UserProfileRequestModel(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
