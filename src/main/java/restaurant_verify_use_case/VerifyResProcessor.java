package restaurant_verify_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the processor for the restaurant verify use case.
 */
public class VerifyResProcessor implements VerifyResPresenter {

    private VerifyResScreenInterface verifyResScreenInterface;

    /**
     * Constructor for VerifyResProcessor.
     *
     * @param verifyResScreenInterface the view
     */
    public VerifyResProcessor(VerifyResScreenInterface verifyResScreenInterface) {
        this.verifyResScreenInterface = verifyResScreenInterface;
    }

    /**
     * When verification success, create a new restaurant homepage for the current user
     * close the verification window,
     *
     * @param currentRestaurantId id of the current restaurant
     * @param restaurantName      name of the current restaurant
     */
    @Override
    public void verifiedSuccess(ObjectId currentRestaurantId, String restaurantName) {
        // Go to user homepage and pass the current user, note user means rest. in this case
        verifyResScreenInterface.showRestaurantHomePage(currentRestaurantId, restaurantName);
        verifyResScreenInterface.close();
    }

    /**
     * When verification failed, display a message to the user.
     */
    @Override
    public void verifiedFailed() {
        verifyResScreenInterface.showMessage("Failed");
    }

    /**
     * Sets the current screen
     *
     * @param verifyResScreenInterface new screen
     */
    public void setVerifyResScreenInterface(VerifyResScreenInterface verifyResScreenInterface) {
        this.verifyResScreenInterface = verifyResScreenInterface;
    }
}