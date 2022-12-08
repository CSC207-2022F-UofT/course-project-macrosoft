package user_profile_use_case;

/**
 * This interface is the input boundary of the user profile.
 */
public interface UserProfileInputBoundary {
    /**
     * Display user profile.
     *
     * @param userProfileRequestModel the request model
     */
    void displayUserProfile(UserProfileRequestModel userProfileRequestModel);
}
