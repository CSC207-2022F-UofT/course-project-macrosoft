package login_use_case;

import database.*;

import library.PasswordHasher;

import entities.*;

/**
 * This class is the interactor for the restaurant login use case.
 */
public class RestaurantLoginInteractor implements RestaurantLoginInputBoundary {
    private final UserLoginOutputBoundary presenter;

    /**
     * Constructor for RestaurantLoginInteractor
     *
     * @param presenter the presenter
     */
    public RestaurantLoginInteractor(UserLoginOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Login the restaurant
     *
     * @param requestModel the request model
     * @return 1000: Success
     *         1001: Not Verified
     *         1002: Invalid Credential
     */
    public UserLoginResponseModel login(RestaurantLoginRequestModel requestModel) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
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

        return presenter.loginFailed(new UserLoginResponseModel(1003, null, null));
    }
}
