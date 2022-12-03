package verify_restaurant_use_case;

import org.bson.types.ObjectId;

public class VerifyResFacade {

    public void generateEmail(ObjectId restaurantID, String email) {
        verify_restaurant_use_case.GenerateEmailInteractor generateEmailInteractor = new GenerateEmailInteractor();
        generateEmailInteractor.generateVerificationEmail(restaurantID, email);
    }

    public int verifyRes(ObjectId restaurantID, String code) {
        VerifyResInteractor verifyResInteractor = new VerifyResInteractor();
        return verifyResInteractor.verifyRes(restaurantID, code);
    }
}
