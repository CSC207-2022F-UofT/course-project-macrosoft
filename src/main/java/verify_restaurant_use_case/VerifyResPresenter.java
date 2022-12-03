package verify_restaurant_use_case;

import org.bson.types.ObjectId;

public interface VerifyResPresenter {
    public String verifiedSuccess(ObjectId currentUser);
    public String verifiedFailed();
}