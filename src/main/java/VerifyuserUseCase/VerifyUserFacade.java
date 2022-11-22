package VerifyuserUseCase;


import org.bson.types.ObjectId;

public class VerifyUserFacade {


    public void generateEmail(ObjectId userID, String email) {
        GenerateEmailInteractor generateEmailInteractor = new GenerateEmailInteractor();
        generateEmailInteractor.generateVerificationEmail(userID, email);
    }

    public int verifyUser(ObjectId userID, String code) {
        VerifyUserInteractor verifyUserInteractor = new VerifyUserInteractor();
        return verifyUserInteractor.verifyUser(userID, code);
    }
}
