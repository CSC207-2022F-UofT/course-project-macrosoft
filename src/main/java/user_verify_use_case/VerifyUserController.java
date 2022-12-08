package user_verify_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the controller of verify user use case.
 */
public class VerifyUserController {
    final VerifyUserFacade verifyUserFacade;
    private final ObjectId currentUserId;

    /**
     * Constructor of VerifyUserController.
     *
     * @param verifyUserFacade a verify user facade
     * @param currentUserId    a user id
     */
    public VerifyUserController(VerifyUserFacade verifyUserFacade, ObjectId currentUserId) {
        this.verifyUserFacade = verifyUserFacade;
        this.currentUserId = currentUserId;
    }

    /**
     * Verify user.
     *
     * @param code a verification code
     */
    public void verifyUser(String code) {
        verifyUserFacade.verifyUser(this.currentUserId, code);
    }

    /**
     * Resend verification code.
     */
    public void generateEmail() {
        verifyUserFacade.generateEmail(this.currentUserId);
    }
}
