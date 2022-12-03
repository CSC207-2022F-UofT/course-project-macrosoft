package register_use_case;

import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.BasicBSONList;
import org.bson.BsonValue;


public class RegisterUserInteractor {

    public RegisterUserInteractor() {}

    /**
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @return 1000: Success
     * 1001: Username Exists
     */
    public static int registerUser(String username, String password, String firstName, String lastName, String email) {
        DBConnection dbConnection = new MongoConnection();

        // Check if username exists
        Bson filter = Filters.eq("username", username);

        if (dbConnection.getCollection("AuthInfo").find(filter).first() != null) {
            return 1001;
        }

        Document newUserDoc = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("orders", new BasicBSONList())
                .append("verified", false);

        InsertOneResult result = dbConnection.getCollection("Users").insertOne(newUserDoc);

        BsonValue userID = result.getInsertedId();
        Document newUserAuthInfo = new Document("username", username)
                .append("password", password)
                .append("userID", userID);

        dbConnection.getCollection("AuthInfo").insertOne(newUserAuthInfo);


        return 1000;
    }


}
