package verify_restaurant_use_case;

import org.bson.types.ObjectId;

public class VerifyResProcessor implements VerifyResPresenter {

    private VerifyResScreenInterface verifyResScreenInterface;

    public VerifyResProcessor(VerifyResScreenInterface verifyResScreenInterface) {
        this.verifyResScreenInterface = verifyResScreenInterface;
    }

    /**
     * @param currentRestaurantId
     * @return
     */

    @Override
    public String verifiedSuccess(ObjectId currentRestaurantId) {
        // Go to user homepage and pass the current user, note user means rest. in this case
        verifyResScreenInterface.showRestaurantHomePage(currentRestaurantId);
        verifyResScreenInterface.close();
        return null;
    }

    /**
     * @return
     */
    @Override
    public String verifiedFailed() {
        verifyResScreenInterface.showMessage("Failed");
        return null;
    }

    public VerifyResScreenInterface getVerifyResScreenInterface() {
        return verifyResScreenInterface;
    }

    public void setVerifyResScreenInterface(VerifyResScreenInterface verifyResScreenInterface) {
        this.verifyResScreenInterface = verifyResScreenInterface;
    }
}