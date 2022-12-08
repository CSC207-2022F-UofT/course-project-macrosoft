package user_register_use_case;

/**
 * This interface is the input boundary of the user register use case.
 */
public interface RegisterUserInputBoundary {
    /**
     * Register user.
     *
     * @param requestModel the request model
     */
    int registerUser(RegisterUserRequestModel requestModel);
}
