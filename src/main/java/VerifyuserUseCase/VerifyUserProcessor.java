package VerifyuserUseCase;

import Entities.User;
import org.bson.types.ObjectId;

public class VerifyUserProcessor implements VerifyUserPresenter{
    /**
     * @param currentUser
     * @return
     */
    @Override
    public String verifiedSuccess(ObjectId currentUser) {
        // Goto user homepage and pass the current user
        return null;
    }

    /**
     * @return
     */
    @Override
    public String verifiedFailed() {
        return null;
    }
}
