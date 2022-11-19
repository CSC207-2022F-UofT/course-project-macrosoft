package verifyuser_use_case;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class VerifyUser {
    /**
     * @param userID
     * @param code
     * @return 1000: Success
     * 1001: Entered Incorrect Code
     * 1002: Expired or code doesn't exist
     */
    public static int verifyUser(ObjectId userID, String code) {
        String actualCode = GetCode.getVerificationCode(userID);

        if (actualCode.isEmpty()) {
            return 1002;
        } else if (!code.equals(actualCode)) {
            return 1001;
        }

        Bson filter = Filters.eq("userID", userID);
        connectionManager.getCollection("Verification").deleteOne(filter);

        filter = Filters.eq("_id", userID);
        Bson update = Updates.set("verified", true);
        connectionManager.getCollection("Users").updateOne(filter, update);

        return 1000;
    }
}
