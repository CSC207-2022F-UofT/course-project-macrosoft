package user_register_use_case;

import database.*;
import entities.AuthInfo;
import com.mongodb.client.model.Filters;
import library.PasswordHasher;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * This class is the interactor of the user register use case.
 */
public class RegisterUserInteractor implements RegisterUserInputBoundary {

    private final RegisterUserOutputBoundary presenter;

    /**
     * Constructor for RegisterUserInteractor
     *
     * @param presenter the presenter
     */
    public RegisterUserInteractor(RegisterUserOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Register user.
     *
     * @param requestModel the request model
     * @return 1000: Success
     * 1001: Username Exists
     */
    public int registerUser(RegisterUserRequestModel requestModel) {
        if (!requestModel.getEmail().matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
            presenter.registerFailed("Invalid email");
            return 1002;
        }

        if (requestModel.getUsername().length() < 6) {
            presenter.registerFailed("Username Too Short");
            return 1002;
        }

        // Check if username exists
        Bson filter = Filters.eq("username", requestModel.getUsername());

        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
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
