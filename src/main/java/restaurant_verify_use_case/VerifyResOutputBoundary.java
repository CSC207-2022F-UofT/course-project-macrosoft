package restaurant_verify_use_case;

import org.bson.types.ObjectId;

/**
 * presenter of the restaurant verify use case
 */
public interface VerifyResOutputBoundary {
    /**
     * Susseccfully verified the current restaurant.
     *
     * @param currentRestaurantId the restaurant id
     * @param restaurantName      the restaurant name
     */
    void verifiedSuccess(ObjectId currentRestaurantId, String restaurantName);

    /**
     * Failed to verify the current restaurant.
     */
    void verifiedFailed();

    /**
     * Sets verify restaurant view.
     *
     * @param verifyResScreenInterface the verify restaurant view
     */
    void setVerifyResScreenInterface(VerifyResScreenInterface verifyResScreenInterface);
}