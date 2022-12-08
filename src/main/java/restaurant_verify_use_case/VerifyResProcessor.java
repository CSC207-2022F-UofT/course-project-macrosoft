package restaurant_verify_use_case;

import org.bson.types.ObjectId;

public class VerifyResProcessor implements VerifyResPresenter {

    private VerifyResScreenInterface verifyResScreenInterface;

    public VerifyResProcessor(VerifyResScreenInterface verifyResScreenInterface) {
        this.verifyResScreenInterface = verifyResScreenInterface;
    }

    /**
     *  When verification success, create a new restaurant homepage for the current user
     *  close the verification window,
     * @param currentRestaurantId id of the current restaurant
     * @param restaurantName name of the current restaurant
     */
    @Override
    public void verifiedSuccess(ObjectId currentRestaurantId, String restaurantName) {
        // Go to user homepage and pass the current user, note user means rest. in this case
        verifyResScreenInterface.showRestaurantHomePage(currentRestaurantId, restaurantName);
        verifyResScreenInterface.close();
    }

    /**
     * when verification failed, display a message to the user.
     */
    @Override
    public void verifiedFailed() {
        verifyResScreenInterface.showMessage("Failed");
    }

    /**
     * set the current screen
     * @param verifyResScreenInterface new screen
     */
    public void setVerifyResScreenInterface(VerifyResScreenInterface verifyResScreenInterface) {
        this.verifyResScreenInterface = verifyResScreenInterface;
    }
}