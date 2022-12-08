package user_verify_use_case;


import org.bson.types.ObjectId;

/**
 * This class is the facade of verify user use case.
 */
public class VerifyUserFacade {

    private final VerifyUserOutputBoundary verifyUserOutputBoundary;

    /**
     * Constructor of VerifyUserFacade.
     *
     * @param verifyUserOutputBoundary a verify user presenter
     */
    public VerifyUserFacade(VerifyUserOutputBoundary verifyUserOutputBoundary) {
        this.verifyUserOutputBoundary = verifyUserOutputBoundary;
    }

    /**
     * Generate email to user with its id.
     *
     * @param userID a user id
     */
    public void generateEmail(ObjectId userID) {
        GenerateEmailInteractor generateEmailInteractor = new GenerateEmailInteractor();
        generateEmailInteractor.generateVerificationEmail(userID);
    }

    /**
     * Verify user with its id and verification code.
     *
     * @param userID a user id
     * @param code   a verification code
     */
    public void verifyUser(ObjectId userID, String code) {
        VerifyUserInteractor verifyUserInteractor = new VerifyUserInteractor(this.verifyUserOutputBoundary);
        verifyUserInteractor.verifyUser(userID, code);
    }
}
