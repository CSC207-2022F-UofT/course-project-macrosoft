package login_use_case;

/**
 * presenter of the login use case
 */
public interface UserLoginOutputBoundary {
    /**
     * present the login success
     *
     * @param response the response model
     */
    UserLoginResponseModel loginSuccess(UserLoginResponseModel response);

    /**
     * present the login failure
     *
     * @param response the response model
     */
    UserLoginResponseModel loginFailed(UserLoginResponseModel response);

    /**
     * present the user not verified
     *
     * @param response the response model
     */
    UserLoginResponseModel userNotVerified(UserLoginResponseModel response);

    /**
     * present the restaurant is not verified
     *
     * @param response the response model
     */
    UserLoginResponseModel restaurantNotVerified(UserLoginResponseModel response);

    /**
     * present the restaurant login success
     *
     * @param response the response model
     */
    UserLoginResponseModel loginRestSuccess(UserLoginResponseModel response);

    /**
     * present the login screen\
     *
     * @param loginScreen the login screen
     */
    void setLoginScreen(UserLoginScreenInterface loginScreen);
}
