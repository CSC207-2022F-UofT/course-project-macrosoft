package restaurant_verify_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the facade for the restaurant verify use case.
 */
public class VerifyResFacade {

    private final VerifyResOutputBoundary presenter;

    /**
     * Constructor for VerifyResFacade.
     *
     * @param presenter the presenter
     */
    public VerifyResFacade(VerifyResOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Generates email for the restaurant by its id.
     *
     * @param restaurantID the restaurant id
     */
    public void generateEmail(ObjectId restaurantID) {
        GenerateEmailInteractor generateEmailInteractor = new GenerateEmailInteractor(presenter);
        generateEmailInteractor.generateVerificationEmail(restaurantID);
    }

    /**
     * Verifies restaurant by its id and code.
     *
     * @param restaurantID the restaurant id
     * @param code         the code
     */
    public int verifyRes(ObjectId restaurantID, String code) {
        VerifyResInteractor verifyResInteractor = new VerifyResInteractor(presenter);
        return verifyResInteractor.verifyRes(restaurantID, code);
    }
}
