package user_profile_use_case;

import org.bson.types.ObjectId;

public interface UserProfileInputBoundary {
    void displayUserProfile(UserProfileRequestModel userProfileRequestModel);
}
