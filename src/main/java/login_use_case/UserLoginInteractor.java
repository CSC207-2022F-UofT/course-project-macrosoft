package login_use_case;

import database.*;

import entities.*;
import library.PasswordHasher;

/**
 * This class is the interactor for the user login use case.
 */
public class UserLoginInteractor implements UserLoginInputBoundary {
    private final UserLoginPresenter presenter;

    /**
     * Constructor for UserLoginInteractor
     *
     * @param presenter the presenter
     */
    public UserLoginInteractor(UserLoginPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Login the user
     *
     * @param requestModel the request model
     */
    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        String hashedPassword;
        try {
            hashedPassword = PasswordHasher.toHexString(PasswordHasher.getSHA(requestModel.getPassword()));
        } catch (Exception e) {
            return presenter.loginFailed(new UserLoginResponseModel(1003, null, null));
        }

        AuthInfo authInfo = authInfoDataGateway.getUserByUsernamePassword(requestModel.getUsername(), hashedPassword);

        if (authInfo != null) {
            User user = userDataGateway.findById(authInfo.getUserId());

            if (user == null) {
                return presenter.loginFailed(new UserLoginResponseModel(1003, null, null));
            }

            boolean verified = user.isVerified();

            if (!verified) {
                return presenter.userNotVerified(new UserLoginResponseModel(1001, authInfo.getUsername(), authInfo.getUserId()));
            } else {
                return presenter.loginSuccess(new UserLoginResponseModel(1000, authInfo.getUsername(), authInfo.getUserId()));
            }
        }

        return presenter.loginFailed(new UserLoginResponseModel(1003, null, null));
    }
}
