package LoginUseCase;


import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import Entities.*;

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
                    userDocument.getList("orders", ObjectId.class),
                    userDocument.getBoolean("verified"));

            return user;
        }

        return null;
    }

}
