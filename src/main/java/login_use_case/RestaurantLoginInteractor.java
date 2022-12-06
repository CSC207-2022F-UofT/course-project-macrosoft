package login_use_case;

import database.*;
import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import library.PasswordHasher;
import org.bson.Document;
import org.bson.conversions.Bson;

import entities.*;

public class RestaurantLoginInteractor implements RestaurantLoginInputBoundary{
    private UserLoginPresenter presenter;

    public RestaurantLoginInteractor(UserLoginPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param requestModel
     * @return 1000: Success
     * 1001: Not Verified
     * 1002: Invalid Credential
     */
    public UserLoginResponseModel login(RestaurantLoginRequestModel requestModel) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(fetcher);
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

        String hashedPassword;
        try {
            hashedPassword = PasswordHasher.toHexString(PasswordHasher.getSHA(requestModel.getPassword()));
        } catch (Exception e) {
            return null;
        }

        AuthInfo authInfo = authInfoDataGateway.getUserByUsernamePassword(requestModel.getUsername(), hashedPassword);

        if (authInfo != null) {
            Restaurant restaurant = restaurantDataGateway.findById(authInfo.getUserId());

            if (restaurant == null) {
                return presenter.loginFailed(new UserLoginResponseModel(1003, null, null));
            }

            boolean verified = restaurant.isVerified();

            if (!verified) {
                return presenter.restaurantNotVerified(new UserLoginResponseModel(1001, restaurant.getName(), authInfo.getUserId()));
            } else {
                return presenter.loginRestSuccess(new UserLoginResponseModel(1000, restaurant.getName(), authInfo.getUserId()));
            }
        }

        return presenter.loginFailed(new UserLoginResponseModel(1003, null,null));
    }
}
