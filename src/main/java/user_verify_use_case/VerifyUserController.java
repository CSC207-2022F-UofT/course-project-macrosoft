package user_verify_use_case;

import org.bson.types.ObjectId;

public class VerifyUserController {
    final VerifyUserFacade verifyUserFacade;
    private ObjectId currentUserId;

    public VerifyUserController(VerifyUserFacade verifyUserFacade, ObjectId currentUserId) {
        this.verifyUserFacade = verifyUserFacade;
        this.currentUserId = currentUserId;
    }

    public int verifyUser(String code) {
        return verifyUserFacade.verifyUser(this.currentUserId, code);
    }

    public void generateEmail() {
        verifyUserFacade.generateEmail(this.currentUserId);
    }
}
