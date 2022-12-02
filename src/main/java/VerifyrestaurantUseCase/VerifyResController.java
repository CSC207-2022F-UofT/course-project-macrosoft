package VerifyrestaurantUseCase;

import VerifyrestaurantUseCase.VerifyResFacade;

import org.bson.types.ObjectId;

public class VerifyResController {
    final VerifyResFacade verifyResFacade;

    public VerifyResController(VerifyResFacade verifyResFacade) {
        this.verifyResFacade = verifyResFacade;
    }

    public int verifyRes(ObjectId currentUser, String code) {
        return verifyResFacade.verifyRes(currentUser, code);
    }

    public void generateEmail(ObjectId restaurantId, String email) {
        verifyResFacade.generateEmail(restaurantId, email);
    }
}
