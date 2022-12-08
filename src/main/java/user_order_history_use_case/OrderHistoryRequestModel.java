package user_order_history_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the request model of the user order history.
 */
public class OrderHistoryRequestModel {
    private final ObjectId currentUserId;

    /**
     * Constructor for OrderHistoryRequestModel
     *
     * @param currentUserId the current user id
     */
    public OrderHistoryRequestModel(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }

    /**
     * Gets current user id.
     *
     * @return the current user id
     */
    public ObjectId getCurrentUserId() {
        return currentUserId;
    }
}
