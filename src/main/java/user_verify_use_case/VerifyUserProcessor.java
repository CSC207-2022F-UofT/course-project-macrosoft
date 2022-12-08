package user_verify_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the processor of verify user use case.
 */
public class VerifyUserProcessor implements VerifyUserPresenter {
    private VerifyUserScreenInterface verifyUserScreen;

    /**
     * Constructor of VerifyUserProcessor.
     *
     * @param verifyUserScreen a verify user screen
     */
    public VerifyUserProcessor(VerifyUserScreenInterface verifyUserScreen) {
        this.verifyUserScreen = verifyUserScreen;
    }

    /**
     * When verification success, create a new homepage for the current user, close the verification window.
     *
     * @param currentUser user id
     */
    @Override
    public void verifiedSuccess(ObjectId currentUser) {
        // Go to user's homepage and pass the current user
        this.verifyUserScreen.showUserHomepage(currentUser);
        this.verifyUserScreen.close();
    }

    /**
     * When verification failed, show a message
     */
    @Override
    public void verifiedFailed() {
        verifyUserScreen.showMessage("Failed");
    }

    /**
     * Sets the current screen to the given screen
     *
     * @param verifyUserScreen new screen
     */
    public void setVerifyUserScreen(VerifyUserScreenInterface verifyUserScreen) {
        this.verifyUserScreen = verifyUserScreen;
    }
}
