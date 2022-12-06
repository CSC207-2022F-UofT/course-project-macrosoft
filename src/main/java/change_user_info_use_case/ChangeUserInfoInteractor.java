package change_user_info_use_case;

import database.MongoCollectionFetcher;
import database.UserDataGateway;
import database.UserDataProcessorMongo;

// Use case layer

public class ChangeUserInfoInteractor implements ChangeUserInfoInputBoundary {
    ChangeUserInfoPresenter presenter;

    public ChangeUserInfoInteractor(ChangeUserInfoPresenter presenter) {
        this.presenter = presenter;
    }

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
