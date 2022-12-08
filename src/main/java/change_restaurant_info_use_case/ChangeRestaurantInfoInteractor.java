package change_restaurant_info_use_case;

import database.*;

/**
 * This class is the interactor for the change restaurant information use case.
 */
public class ChangeRestaurantInfoInteractor implements ChangeRestaurantInfoInputBoundary {
    ChangeRestaurantInfoOutputBoundary presenter;

    /**
     * Constructor for ChangeRestaurantInfoInteractor
     *
     * @param presenter the presenter
     */
    public ChangeRestaurantInfoInteractor(ChangeRestaurantInfoOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Change restaurant information according to the given request model.
     * @param requestModel request model
     */
    @Override
    public void changeRestaurantInfo(ChangeRestaurantInfoRequestModel requestModel) {
        if (requestModel.getRestaurantId() == null) presenter.changeRestaurantInfoFailed("Invalid restaurant");

        try {
            MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
            RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

            restaurantDataGateway.updateRestaurantInfo(
                    requestModel.getRestaurantId(),
                    requestModel.getNewName(),
                    requestModel.getNewEmail(),
                    requestModel.getNewLocation(),
                    requestModel.getNewPhone()
            );

            presenter.changeRestaurantInfoSuccess("Change restaurant info success");
        } catch (Exception e) {
            presenter.changeRestaurantInfoFailed("Change restaurant info failed");
        }
    }
}
