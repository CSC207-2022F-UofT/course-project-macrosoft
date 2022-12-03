package loginusecase;

import database.AuthInfoDataGateway;
import database.AuthInfoProcessorMongo;
import database.MongoCollectionFetcher;

import entities.*;

public class UserLoginInteractor implements UserLoginInputBoundary {
    private UserLoginPresenter presenter;

    public UserLoginInteractor(UserLoginPresenter presenter) {
        this.presenter = presenter;
    }

    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(fetcher);

        AuthInfo authInfo = authInfoDataGateway.getUserByUsernamePassword(requestModel.getUsername(), requestModel.getPassword());

        if (authInfo != null) {

            User currentUser = UserInfoAccessor.getUserProfile(authInfo.getUserId());

            if (!currentUser.isVerified()) {
                return presenter.notVerified(new UserLoginResponseModel(1001, currentUser));
            } else {
                return presenter.loginSuccess(new UserLoginResponseModel(1000, currentUser));
            }
        }

        return presenter.loginFailed(new UserLoginResponseModel(1003, null));
    }
}
