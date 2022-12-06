package restaurant_verify_use_case;

import org.bson.types.ObjectId;

public interface VerifyResPresenter {
    String verifiedSuccess(ObjectId currentRestaurantId, String restaurantName);
    String verifiedFailed();
    void setVerifyResScreenInterface(VerifyResScreenInterface verifyResScreenInterface);
}