package user_profile_use_case;

import Database.MongoCollectionFetcher;
import Database.UserDataGateway;
import Database.UserDataProcessorMongo;
import Entities.User;
import org.bson.types.ObjectId;

public class UserProfileInteractor implements UserProfileInputBoundary {

    private UserProfilePresenter presenter;

    public UserProfileInteractor(UserProfilePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @param userId
     */
    @Override
    public void displayUserProfile(UserProfileRequestModel userProfileRequestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = new MongoCollectionFetcher();
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
