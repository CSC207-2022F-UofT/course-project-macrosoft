package login_use_case;


import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import entities.*;

public class UserInfoAccessor {


    public static User getUserProfile(ObjectId userID) {
        DBConnection dbConnection = new MongoConnection();

        Bson queryFilter = Filters.eq("_id", userID);

        MongoIterable<Document> results =
                dbConnection.getCollection("Users").find(queryFilter);

        if (results.first() != null) {
            Document userDocument = results.first();

            User user = new User(userDocument.getString("firstName"),
                    userDocument.getString("lastName"),
                    userDocument.getString("email"),
                    userDocument.getObjectId("_id"),
                    userDocument.getBoolean("verified"));

            return user;
        }

        return null;
    }

}
