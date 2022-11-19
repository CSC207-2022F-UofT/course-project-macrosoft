package login_use_case;


import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import database_access.ConnectionManager;
import entities.*;

public class UserInfoAccessor {

    private static ConnectionManager connectionManager = new ConnectionManager();

    public static User getUserProfile(ObjectId userID) {
        Bson queryFilter = Filters.eq("_id", userID);

        MongoIterable<Document> results =
                connectionManager.getCollection("Users").find(queryFilter);

        if (results.first() != null) {
            Document userDocument = results.first();

            User user = new User(userDocument.getString("firstName"),
                    userDocument.getString("lastName"),
                    userDocument.getString("email"),
                    userDocument.getObjectId("_id"),
                    userDocument.getList("orders", ObjectId.class),
                    userDocument.getBoolean("verified"));

            return user;
        }

        return null;
    }

}
