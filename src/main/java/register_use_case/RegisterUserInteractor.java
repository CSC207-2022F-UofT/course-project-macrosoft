package register_use_case;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;
import org.bson.BsonValue;

import java.io.UnsupportedEncodingException;
import java.util.*;


import database_access.ConnectionManager;
import entities.*;

public class RegisterUserInteractor {

    private static ConnectionManager connectionManager = new ConnectionManager();

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
        // Check if username exists
        Bson filter = Filters.eq("username", username);

        if (connectionManager.getCollection("AuthInfo").find(filter).first() != null) {
            return 1001;
        }

        Document newUserDoc = new Document("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("orders", new BasicBSONList())
                .append("verified", false);

        InsertOneResult result = connectionManager.getCollection("Users").insertOne(newUserDoc);

        BsonValue userID = result.getInsertedId();
        Document newUserAuthInfo = new Document("username", username)
                .append("password", password)
                .append("userID", userID);

        connectionManager.getCollection("AuthInfo").insertOne(newUserAuthInfo);


        return 1000;
    }


}
