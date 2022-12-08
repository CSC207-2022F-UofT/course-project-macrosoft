package user_verify_use_case;


import org.bson.types.ObjectId;

/**
 * This class is the facade of verify user use case.
 */
public class VerifyUserFacade {

    private final VerifyUserPresenter verifyUserPresenter;

    /**
     * Constructor of VerifyUserFacade.
     *
     * @param verifyUserPresenter a verify user presenter
     */
    public VerifyUserFacade(VerifyUserPresenter verifyUserPresenter) {
        this.verifyUserPresenter = verifyUserPresenter;
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
        VerifyUserInteractor verifyUserInteractor = new VerifyUserInteractor(this.verifyUserPresenter);
        verifyUserInteractor.verifyUser(userID, code);
    }
}
