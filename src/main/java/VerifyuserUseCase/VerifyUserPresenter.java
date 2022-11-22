package VerifyuserUseCase;

import org.bson.types.ObjectId;

public interface VerifyUserPresenter {
    public String verifiedSuccess(ObjectId currentUser);
    public String verifiedFailed();
}
