package user_register_use_case;

/**
 * This class is the controller of the user register use case.
 */
public class RegisterUserController {
    RegisterUserInputBoundary registerUserInteractor;

    /**
     * Constructor for RegisterUserController
     *
     * @param registerUserInteractor the register user interactor
     */
    public RegisterUserController(RegisterUserInputBoundary registerUserInteractor) {
        this.registerUserInteractor = registerUserInteractor;
    }

    /**
     * Register user.
     *
     * @param email     the email
     * @param username  the username
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     */
    public void registerUser(String email, String username, String password, String firstName, String lastName) {
        RegisterUserRequestModel requestModel = new RegisterUserRequestModel(email, username, password, firstName, lastName);
        registerUserInteractor.registerUser(requestModel);
    }
}
