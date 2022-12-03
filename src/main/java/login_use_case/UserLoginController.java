package login_use_case;

public class UserLoginController {

    final UserLoginInputBoundary userInput;

    public UserLoginController(UserLoginInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserLoginResponseModel login(String username, String password) {
        UserLoginRequestModel requestModel = new UserLoginRequestModel(
                username, password);

        return userInput.login(requestModel);
    }
}
