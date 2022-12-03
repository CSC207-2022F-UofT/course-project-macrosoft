package user_profile_use_case;

import org.bson.types.ObjectId;

public class UserProfileController {
    private UserProfileInputBoundary userProfileInteractor;
    private ObjectId currentUserId;

    public UserProfileController(UserProfileInputBoundary userProfileInteractor, ObjectId currentUserId) {
        this.userProfileInteractor = userProfileInteractor;
        this.currentUserId = currentUserId;
    }

    public void getUserProfile() {
        if (this.currentUserId == null) return;

        UserProfileRequestModel userProfileRequestModel = new UserProfileRequestModel(this.currentUserId);
        userProfileInteractor.displayUserProfile(userProfileRequestModel);
    }
}
