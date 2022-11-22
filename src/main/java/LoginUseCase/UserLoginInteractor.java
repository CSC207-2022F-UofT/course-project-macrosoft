package LoginUseCase;

import Database.AuthInfoDataGateway;
import Database.AuthInfoProcessorMongo;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import Entities.*;

public class UserLoginInteractor implements UserLoginInputBoundary {
    private UserLoginPresenter presenter;

    public UserLoginInteractor(UserLoginPresenter presenter) {
        this.presenter = presenter;
    }

    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo();

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
