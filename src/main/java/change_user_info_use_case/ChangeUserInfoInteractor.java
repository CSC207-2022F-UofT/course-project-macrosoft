package change_user_info_use_case;

import database.MongoCollectionFetcher;
import database.UserDataGateway;
import database.UserDataProcessorMongo;

// Use case layer

/**
 * This class is the interactor for the change user information use case.
 */
public class ChangeUserInfoInteractor implements ChangeUserInfoInputBoundary {
    ChangeUserInfoOutputBoundary presenter;

    /**
     * Constructor for ChangeUserInfoInteractor
     *
     * @param presenter the presenter
     */
    public ChangeUserInfoInteractor(ChangeUserInfoOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Change the user information
     *
     * @param requestModel the request model
     */
    @Override
    public void changeUserInfo(ChangeUserInfoRequestModel requestModel) {
        if (requestModel.getUserId() == null) presenter.changeUserInfoFailed("Invalid user");

        try {
            MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
            UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

            userDataGateway.UpdateUserInfo(
                    requestModel.getUserId(),
                    requestModel.getNewFirstName(),
                    requestModel.getNewLastName(),
                    requestModel.getNewEmail()
            );

            presenter.changeUserInfoSuccess("Change user info success");
        } catch (Exception e) {
            presenter.changeUserInfoFailed("Change user info failed");
        }
    }
}
