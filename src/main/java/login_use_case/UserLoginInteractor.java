package login_use_case;

import database.*;

import entities.*;
import library.PasswordHasher;

public class UserLoginInteractor implements UserLoginInputBoundary {
    private UserLoginPresenter presenter;

    public UserLoginInteractor(UserLoginPresenter presenter) {
        this.presenter = presenter;
    }

    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        String hashedPassword;
        try {
            hashedPassword = PasswordHasher.toHexString(PasswordHasher.getSHA(requestModel.getPassword()));
        } catch (Exception e) {
            return null;
        }

        AuthInfo authInfo = authInfoDataGateway.getUserByUsernamePassword(requestModel.getUsername(), hashedPassword);

        if (authInfo != null) {
            boolean verified = userDataGateway.getVerifiedStatus(authInfo.getUserId());

            if (!verified) {
                return presenter.notVerified(new UserLoginResponseModel(1001, authInfo.getUserId()));
            } else {
                return presenter.loginSuccess(new UserLoginResponseModel(1000, authInfo.getUserId()));
            }
        }

        return presenter.loginFailed(new UserLoginResponseModel(1003, null));
    }
}
