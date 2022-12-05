package verify_restaurant_use_case;

import org.bson.types.ObjectId;

public class VerifyResController {
    final VerifyResFacade verifyResFacade;
    private ObjectId currentRestaurantId;


    public VerifyResController(VerifyResFacade verifyResFacade, ObjectId currentRestaurantId) {
        this.verifyResFacade = verifyResFacade;
        this.currentRestaurantId = currentRestaurantId;
    }

    public int verifyRes(String code) {
        return verifyResFacade.verifyRes(currentRestaurantId, code);
    }

    public void generateEmail() {
        verifyResFacade.generateEmail(currentRestaurantId);
    }
}
