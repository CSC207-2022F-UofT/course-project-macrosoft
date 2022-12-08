package user_verify_use_case;
/*
presenter of the use case
 */
import org.bson.types.ObjectId;

public interface VerifyUserPresenter {
    void setVerifyUserScreen(VerifyUserScreenInterface verifyUserScreen);
    void verifiedSuccess(ObjectId currentUser);
    void verifiedFailed();
}
