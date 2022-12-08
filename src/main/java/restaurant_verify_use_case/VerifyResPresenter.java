package restaurant_verify_use_case;
/*
presenter of the restaurant verify use case
 */
import org.bson.types.ObjectId;

public interface VerifyResPresenter {
    void verifiedSuccess(ObjectId currentRestaurantId, String restaurantName);
    void verifiedFailed();
    void setVerifyResScreenInterface(VerifyResScreenInterface verifyResScreenInterface);
}