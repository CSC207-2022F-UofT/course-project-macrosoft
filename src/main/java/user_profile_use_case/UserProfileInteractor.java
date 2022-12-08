package user_profile_use_case;

import database.MongoCollectionFetcher;
import database.UserDataGateway;
import database.UserDataProcessorMongo;
import entities.User;

/**
 * This class is the interactor of the user profile.
 */
public class UserProfileInteractor implements UserProfileInputBoundary {

    private final UserProfileOutputBoundary presenter;

    /**
     * Constructor for UserProfileInteractor
     *
     * @param presenter the presenter
     */
    public UserProfileInteractor(UserProfileOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Display user profile.
     *
     * @param userProfileRequestModel the request model
     */
    @Override
    public void displayUserProfile(UserProfileRequestModel userProfileRequestModel) {
        MongoCollectionFetcher mongoCollectionFetcher = MongoCollectionFetcher.getFetcher();
        UserDataGateway userDataGateway = new UserDataProcessorMongo(mongoCollectionFetcher);

        User user = userDataGateway.findById(userProfileRequestModel.getUserId());

        if (user == null) {
            presenter.userNotFound();
        } else {
            UserProfileResponseModel userProfileResponseModel = new UserProfileResponseModel(user.getFirstName(), user.getLastName(), user.getEmail());
            presenter.userFound(userProfileResponseModel);
        }
    }
}
