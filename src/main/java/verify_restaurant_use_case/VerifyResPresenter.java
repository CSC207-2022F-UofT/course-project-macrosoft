package verify_restaurant_use_case;

import org.bson.types.ObjectId;

public interface VerifyResPresenter {
    String verifiedSuccess(ObjectId currentUser);
    String verifiedFailed();
    void setVerifyResScreenInterface(VerifyResScreenInterface verifyResScreenInterface);
}