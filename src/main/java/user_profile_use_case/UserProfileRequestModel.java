package user_profile_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the request model of the user profile.
 */
public class UserProfileRequestModel {
    private ObjectId userId;

    /**
     * Constructor for UserProfileRequestModel
     *
     * @param userId the user id
     */
    public UserProfileRequestModel(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public ObjectId getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
