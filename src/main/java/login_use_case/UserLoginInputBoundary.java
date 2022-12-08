package login_use_case;

/**
 * This interface is the input boundary for the user login use case.
 */
public interface UserLoginInputBoundary {
    /**
     * Login the user
     *
     * @param requestModel the request model
     */
    UserLoginResponseModel login(UserLoginRequestModel requestModel);
}
