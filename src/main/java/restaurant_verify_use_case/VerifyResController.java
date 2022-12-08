package restaurant_verify_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the controller for the restaurant verify use case.
 */
public class VerifyResController {
    final VerifyResFacade verifyResFacade;
    private final ObjectId currentRestaurantId;

    /**
     * Constructor for VerifyResController.
     *
     * @param verifyResFacade     the facade
     * @param currentRestaurantId the current restaurant id
     */
    public VerifyResController(VerifyResFacade verifyResFacade, ObjectId currentRestaurantId) {
        this.verifyResFacade = verifyResFacade;
        this.currentRestaurantId = currentRestaurantId;
    }

    /**
     * Verifies restaurant.
     *
     * @param code the code
     */
    public void verifyRes(String code) {
        verifyResFacade.verifyRes(currentRestaurantId, code);
    }

    /**
     * Generates email.
     */
    public void generateEmail() {
        verifyResFacade.generateEmail(currentRestaurantId);
    }
}
