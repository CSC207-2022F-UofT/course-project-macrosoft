package verify_user_use_case;


import org.bson.types.ObjectId;

public class VerifyUserFacade {

    private VerifyUserPresenter verifyUserPresenter;

    public VerifyUserFacade(VerifyUserPresenter verifyUserPresenter) {
        this.verifyUserPresenter = verifyUserPresenter;
    }

    public VerifyUserPresenter getVerifyUserPresenter() {
        return verifyUserPresenter;
    }

    public void setVerifyUserPresenter(VerifyUserPresenter verifyUserPresenter) {
        this.verifyUserPresenter = verifyUserPresenter;
    }

    public void generateEmail(ObjectId userID, String email) {
        GenerateEmailInteractor generateEmailInteractor = new GenerateEmailInteractor();
        generateEmailInteractor.generateVerificationEmail(userID, email);
    }

    public int verifyUser(ObjectId userID, String code) {
        VerifyUserInteractor verifyUserInteractor = new VerifyUserInteractor(this.verifyUserPresenter);
        return verifyUserInteractor.verifyUser(userID, code);
    }
}
