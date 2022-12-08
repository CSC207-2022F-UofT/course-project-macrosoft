package user_order_history_use_case;

import org.bson.types.ObjectId;

public class OrderHistoryRequestModel {
    private ObjectId currentUserId;
    public OrderHistoryRequestModel(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }

    public ObjectId getCurrentUserId() {
        return currentUserId;
    }

    public void setCurUser(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }
}
