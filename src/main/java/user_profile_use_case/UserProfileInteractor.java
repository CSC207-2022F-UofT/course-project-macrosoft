package user_profile_use_case;

import database.MongoCollectionFetcher;
import database.UserDataGateway;
import database.UserDataProcessorMongo;
import entities.User;

public class UserProfileInteractor implements UserProfileInputBoundary {

    private UserProfilePresenter presenter;

    public UserProfileInteractor(UserProfilePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param
     */
    @Override
    public void displayUserProfile(UserProfileRequestModel userProfileRequestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        UserDataGateway userDataGateway = new UserDataProcessorMongo(mongoCollectionFetcher);

        User user = userDataGateway.findById(userProfileRequestModel.getUserId());

        if (user == null) {
            presenter.userNotFound();
        }
        else {
            UserProfileResponseModel userProfileResponseModel = new UserProfileResponseModel(user.getFirstName(), user.getLastName(), user.getEmail());
            presenter.userFound(userProfileResponseModel);
        }
    }
}
