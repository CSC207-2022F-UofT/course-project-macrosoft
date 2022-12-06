package user_register_use_case;

public class RegisterUserController {
    RegisterUserInputBoundary registerUserInteractor;

    public RegisterUserController(RegisterUserInputBoundary registerUserInteractor) {
        this.registerUserInteractor = registerUserInteractor;
    }

    public void registerUser(String email, String username, String password, String firstName, String lastName) {
        RegisterUserRequestModel requestModel = new RegisterUserRequestModel(email, username, password, firstName, lastName);
        registerUserInteractor.registerUser(requestModel);
    }
}
