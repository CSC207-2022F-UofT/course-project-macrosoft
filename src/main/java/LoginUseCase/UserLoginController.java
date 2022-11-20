package LoginUseCase;

import LoginUseCase.UserLoginInputBoundary;
import LoginUseCase.UserLoginRequestModel;
import LoginUseCase.UserLoginResponseModel;

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
