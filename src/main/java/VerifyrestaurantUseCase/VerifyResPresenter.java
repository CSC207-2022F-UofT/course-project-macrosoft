package VerifyrestaurantUseCase;

import org.bson.types.ObjectId;

public interface VerifyResPresenter {
    public String verifiedSuccess(ObjectId currentUser);
    public String verifiedFailed();
}