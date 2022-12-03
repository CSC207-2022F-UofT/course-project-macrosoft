package verify_user_use_case;

import org.bson.types.ObjectId;

public class VerifyUserController {
    final VerifyUserFacade verifyUserFacade;

    public VerifyUserController(VerifyUserFacade verifyUserFacade) {
        this.verifyUserFacade = verifyUserFacade;
    }

    public int verifyUser(ObjectId currentUser, String code) {
        return verifyUserFacade.verifyUser(currentUser, code);
    }

    public void generateEmail(ObjectId userId, String email) {
        verifyUserFacade.generateEmail(userId, email);
    }
}
