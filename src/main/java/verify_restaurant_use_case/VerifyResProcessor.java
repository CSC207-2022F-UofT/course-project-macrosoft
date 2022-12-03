package verify_restaurant_use_case;

import org.bson.types.ObjectId;

public class VerifyResProcessor implements VerifyResPresenter {
    /**
     * @param currentUser
     * @return
     */

    @Override
    public String verifiedSuccess(ObjectId currentUser) {
        // Go to user homepage and pass the current user, note user means rest. in this case
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