package restaurant_register_use_case;

import database.*;
import library.PasswordHasher;
import org.bson.types.ObjectId;

public class RegisterRestaurantInteractor implements RegisterRestaurantInputBoundary{

    private RegisterRestaurantPresenter presenter;
    public RegisterRestaurantInteractor(RegisterRestaurantPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param requestModel
     * @return 1000: Success
     * 1001: Username Exists
     */
    public int registerRestaurant(RegisterRestaurantRequestModel requestModel) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(fetcher);
        MenuDataGateway menuDataGateway = new MenuDataMongo(fetcher);

        if (authInfoDataGateway.getUserByUsername(requestModel.getUsername()) != null) {
            presenter.registerFailed("Username already exist");
            return 1001;
        }



        ObjectId restID = restaurantDataGateway.newRestaurant(requestModel.getRestaurantName(), requestModel.getEmail(), requestModel.getLocation(), requestModel.getPhone());

        String hashedPassword;
        try {
            hashedPassword = PasswordHasher.toHexString(PasswordHasher.getSHA(requestModel.getPassword()));
        } catch (Exception e) {
            return 1;
        }

        authInfoDataGateway.create(requestModel.getUsername(), hashedPassword, restID);

        ObjectId menuId = menuDataGateway.newMenu(restID);

        restaurantDataGateway.updateMenuId(restID, menuId);

        presenter.registerSuccessful("Success");

        return 1000;
    }
}
