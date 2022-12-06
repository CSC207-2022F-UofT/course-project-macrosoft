package user_verify_use_case;

import org.bson.types.ObjectId;

public interface VerifyUserPresenter {
    void setVerifyUserScreen(VerifyUserScreenInterface verifyUserScreen);
    String verifiedSuccess(ObjectId currentUser);
    String verifiedFailed();
}
