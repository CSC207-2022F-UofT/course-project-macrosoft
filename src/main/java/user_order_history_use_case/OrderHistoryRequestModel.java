package user_order_history_use_case;

import org.bson.types.ObjectId;


/**
 * This class is the request model for the user history use case.
 */
public class OrderHistoryRequestModel {
    private ObjectId currentUserId;

    /**
     * The constructor for the OrderHistoryRequestModel
     *
     * @param currentUserId the current user id
     */
    public OrderHistoryRequestModel(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }


    /**
     * Get the current user ID
     *
     * @return the current user ID
     */
    public ObjectId getCurrentUserId() {
        return currentUserId;
    }


    /**
     * Set the current user ID
     *
     * @param currentUserId The current user ID
     */
    public void setCurUser(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }
}
