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

        return presenter.loginFailed(new UserLoginResponseModel(1003, authInfo.getUsername(), null));
    }
}
