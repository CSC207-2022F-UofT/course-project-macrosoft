package user_profile_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the controller of the user profile.
 */
public class UserProfileController {
    private final UserProfileInputBoundary userProfileInteractor;
    private final ObjectId currentUserId;

    /**
     * Constructor for UserProfileController
     *
     * @param userProfileInteractor the user profile interactor
     * @param currentUserId         the current user id
     */
    public UserProfileController(UserProfileInputBoundary userProfileInteractor, ObjectId currentUserId) {
        this.userProfileInteractor = userProfileInteractor;
        this.currentUserId = currentUserId;
    }

    /**
     * Gets user profile.
     */
    public void getUserProfile() {
        if (this.currentUserId == null) return;

        UserProfileRequestModel userProfileRequestModel = new UserProfileRequestModel(this.currentUserId);
        userProfileInteractor.displayUserProfile(userProfileRequestModel);
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
