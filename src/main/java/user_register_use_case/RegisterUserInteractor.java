package user_register_use_case;

import database.*;
import entities.AuthInfo;
import com.mongodb.client.model.Filters;
import library.PasswordHasher;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class RegisterUserInteractor implements RegisterUserInputBoundary{

    private RegisterUserPresenter presenter;

    public RegisterUserInteractor(RegisterUserPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * @return 1000: Success
     * 1001: Username Exists
     */
    public int registerUser(RegisterUserRequestModel requestModel) {
        // Check if username exists
        Bson filter = Filters.eq("username", requestModel.getUsername());

        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);
        AuthInfoDataGateway authInfoDataGateway = new AuthInfoProcessorMongo(fetcher);

        AuthInfo authInfo = authInfoDataGateway.getUserByUsername(requestModel.getUsername());

        if (authInfo != null) {
            presenter.registerFailed("Username already exist");
            return 1001;
        }

        ObjectId userID = userDataGateway.newUser(requestModel.getEmail(), requestModel.getFirstName(), requestModel.getLastName());

        String hashedPassword;
        try {
            hashedPassword = PasswordHasher.toHexString(PasswordHasher.getSHA(requestModel.getPassword()));
        } catch (Exception e) {
            return 1;
        }

        authInfoDataGateway.create(requestModel.getUsername(), hashedPassword, userID);

        presenter.registerSuccessful("Success");

        return 1000;
    }


}
