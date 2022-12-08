package user_verify_use_case;

import org.bson.types.ObjectId;

public class VerifyUserProcessor implements VerifyUserPresenter {
    private VerifyUserScreenInterface verifyUserScreen;

    public VerifyUserProcessor(VerifyUserScreenInterface verifyUserScreen) {
        this.verifyUserScreen = verifyUserScreen;
    }


    /**
     * when verification success, create a new homepage for the current user, close the verification window.
     * @param currentUser user id
     */
    @Override
    public void verifiedSuccess(ObjectId currentUser) {
        // Go to user's homepage and pass the current user
        this.verifyUserScreen.showUserHomepage(currentUser);
        this.verifyUserScreen.close();
    }

    /**
     * when verification failed, show a message
     */
    @Override
    public void verifiedFailed() {
        verifyUserScreen.showMessage("Failed");
    }

    /**
     * set the current screen to the given screen
     * @param verifyUserScreen new screen
     */
    public void setVerifyUserScreen(VerifyUserScreenInterface verifyUserScreen) {
        this.verifyUserScreen = verifyUserScreen;
    }
}
