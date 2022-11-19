package LoginUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import Entities.*;

public class LoginUserInteractor {
    private static User currentUser = null;

    public LoginUserInteractor() {}

    /**
     * @param username
     * @param password
     * @return 1000: Success
     * 1001: Not Verified
     * 1002: Invalid Credential
     */
    public static int login(String username, String password) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password));

        MongoIterable<Document> users = dbConnection.getCollection("AuthInfo").find(queryFilter);

        if (users.first() != null) {
            Document userDocument = users.first();
            currentUser = UserInfoAccessor.getUserProfile(userDocument.getObjectId("userID"));

            if (!currentUser.isVerified()) {
                return 1001;
            } else {
                return 1000;
            }
        }
        return 1002;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
