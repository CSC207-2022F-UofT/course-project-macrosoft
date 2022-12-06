package restaurant_verify_use_case;

import org.bson.types.ObjectId;

public class VerifyResFacade {

    private VerifyResPresenter presenter;

    public VerifyResFacade(VerifyResPresenter presenter) {
        this.presenter = presenter;
    }

    public void generateEmail(ObjectId restaurantID) {
        GenerateEmailInteractor generateEmailInteractor = new GenerateEmailInteractor(presenter);
        generateEmailInteractor.generateVerificationEmail(restaurantID);
    }

    public int verifyRes(ObjectId restaurantID, String code) {
        VerifyResInteractor verifyResInteractor = new VerifyResInteractor(presenter);
        return verifyResInteractor.verifyRes(restaurantID, code);
    }
}