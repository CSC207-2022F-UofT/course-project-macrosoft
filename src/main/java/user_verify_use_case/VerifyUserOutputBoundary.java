package user_verify_use_case;

import org.bson.types.ObjectId;

/**
 * presenter of the use case
 */
public interface VerifyUserOutputBoundary {
    /**
     * Sets verify user screen.
     *
     * @param verifyUserScreen the verify user screen
     */
    void setVerifyUserScreen(VerifyUserScreenInterface verifyUserScreen);

    /**
     * Verify user successfully.
     *
     * @param currentUser the current user
     */
    void verifiedSuccess(ObjectId currentUser);

    /**
     * Verify user failed.
     */
    void verifiedFailed();
}
