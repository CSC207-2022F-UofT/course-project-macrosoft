package OrderHistoryUseCase;

import Entities.User;
import org.bson.types.ObjectId;

public class OrderHistoryRequestModel {
    private ObjectId userId;
    public OrderHistoryRequestModel(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId user) {
        this.userId = user;
    }
}
