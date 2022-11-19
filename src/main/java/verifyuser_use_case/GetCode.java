package verifyuser_use_case;

import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Date;

public class GetCode {
    public static String getVerificationCode(ObjectId userID) {
        Bson filter = Filters.eq("userID", userID);

        MongoIterable<Document> results = connectionManager.getCollection("Verification").find(filter);

        if (results.first() != null) {
            Document verificationDoc = results.first();

            Date currentTime = new Date();
            Date createdTime = verificationDoc.getDate("createdTime");

            if (currentTime.compareTo(AddMinutes.addMinutesToDate(5, createdTime)) > 0) {
                connectionManager.getCollection("Verification").deleteMany(Filters.eq("userID", userID));
                return "";
            } else {
                return verificationDoc.getString("code");
            }
        } else {
            return "";
        }
    }
}
