package verify_user_use_case;

import org.bson.types.ObjectId;

public class VerifyUserProcessor implements VerifyUserPresenter {
    private VerifyUserScreenInterface verifyUserScreen;

    public VerifyUserProcessor(VerifyUserScreenInterface verifyUserScreen) {
        this.verifyUserScreen = verifyUserScreen;
    }

    /**
     * @param currentUser
     * @return
     */
    @Override
    public String verifiedSuccess(ObjectId currentUser) {
        // Go to user's homepage and pass the current user
        this.verifyUserScreen.showUserHomepage(currentUser);
        this.verifyUserScreen.close();
        return null;
    }

    /**
     * @return
     */
    @Override
    public String verifiedFailed() {
        verifyUserScreen.showMessage("Failed");
        return null;
    }

    public void setVerifyUserScreen(VerifyUserScreenInterface verifyUserScreen) {
        this.verifyUserScreen = verifyUserScreen;
    }
}
