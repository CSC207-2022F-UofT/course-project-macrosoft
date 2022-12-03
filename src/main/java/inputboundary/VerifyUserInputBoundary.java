package inputboundary;

import org.bson.types.ObjectId;

public interface VerifyUserInputBoundary {
    public int verifyUser(ObjectId userID, String code);
}
