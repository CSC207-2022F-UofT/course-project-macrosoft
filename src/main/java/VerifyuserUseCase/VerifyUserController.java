package VerifyuserUseCase;

import InputBoundary.VerifyUserInputBoundary;
import org.bson.types.ObjectId;

public class VerifyUserController {
    final VerifyUserFacade verifyUserFacade;

    public VerifyUserController(VerifyUserFacade verifyUserFacade) {
        this.verifyUserFacade = verifyUserFacade;
    }

    public int verifyUser(ObjectId userID, String code) {
        return verifyUserFacade.verifyUser(userID, code);
    }

    public void generateEmail(ObjectId userId, String email) {
        verifyUserFacade.generateEmail(userId, email);
    }
}
