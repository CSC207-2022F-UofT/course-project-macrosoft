package change_restaurant_info_use_case;

import database.*;

public class ChangeRestaurantInfoInteractor implements ChangeRestaurantInfoInputBoundary{
    ChangeRestaurantInfoPresenter presenter;

    public ChangeRestaurantInfoInteractor(ChangeRestaurantInfoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void changeRestaurantInfo(ChangeRestaurantInfoRequestModel requestModel) {
        if (requestModel.getRestaurantId() == null) presenter.changeRestaurantInfoFailed("Invalid restaurant");

        try {
            MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
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
