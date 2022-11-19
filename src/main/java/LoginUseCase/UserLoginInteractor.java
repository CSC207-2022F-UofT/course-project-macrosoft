package LoginUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import Entities.*;

public class UserLoginInteractor implements UserLoginInputBoundary {
    public UserLoginInteractor() {
    }

    public UserLoginResponseModel login(UserLoginRequestModel requestModel) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.and(
                Filters.eq("username", requestModel.getUsername()),
                Filters.eq("password", requestModel.getPassword()));

        MongoIterable<Document> users = dbConnection.getCollection("AuthInfo").find(queryFilter);

        if (users.first() != null) {
            Document userDocument = users.first();

            User currentUser = UserInfoAccessor.getUserProfile(userDocument.getObjectId("userID"));

            if (!currentUser.isVerified()) {
                return new UserLoginResponseModel(1001, currentUser);
            } else {
                return new UserLoginResponseModel(1000, currentUser);
            }
        }

        return new UserLoginResponseModel(1002, null);
    }
}
