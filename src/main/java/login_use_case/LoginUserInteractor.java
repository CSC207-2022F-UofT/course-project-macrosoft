package login_use_case;

import entities.User;
import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

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
    public int login(String username, String password) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password));

        MongoIterable<Document> users = dbConnection.getCollection("AuthInfo").find(queryFilter);

        if (users.first() != null) {
            Document authDocument = users.first();
            currentUser = UserInfoAccessor.getUserProfile(authDocument.getObjectId("userID"));

            if (!currentUser.isVerified()) {
                return 1001;
            } else {
                return 1000;
            }
        }
        return 1002;
    }

    public static User getCurUser() {
        return currentUser;
    }
}
