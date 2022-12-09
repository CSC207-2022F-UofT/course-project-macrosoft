package change_user_info_use_case;

// Use case layer

/**
 * This interface is the input boundary for the change user information use case.
 */
public interface ChangeUserInfoInputBoundary {
    /**
     * Change the user information
     *
     * @param requestModel the request model
     */
    void changeUserInfo(ChangeUserInfoRequestModel requestModel);
}
