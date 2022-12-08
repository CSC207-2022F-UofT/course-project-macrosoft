package change_restaurant_info_use_case;

import org.bson.types.ObjectId;

// Interface adapters layer

/**
 * This class is the controller for the change restaurant information use case.
 */
public class ChangeRestaurantInfoController {
    private ChangeRestaurantInfoInputBoundary interactor;
    private final ObjectId currentRestaurantId;

    /**
     * Constructor for ChangeRestaurantInfoController
     *
     * @param interactor          the change restaurant info interactor
     * @param currentRestaurantId the current restaurant id
     */
    public ChangeRestaurantInfoController(ChangeRestaurantInfoInputBoundary interactor, ObjectId currentRestaurantId) {
        this.interactor = interactor;
        this.currentRestaurantId = currentRestaurantId;
    }

    /**
     * Change the restaurant information
     *
     * @param name     the name of the restaurant
     * @param email    the email address of the restaurant
     * @param location the location of the restaurant
     * @param phone    the phone of the restaurant
     */
    public void changeRestaurantInfo(String name, String email, String location, String phone) {
        ChangeRestaurantInfoRequestModel requestModel = new ChangeRestaurantInfoRequestModel(this.currentRestaurantId, null, null, null, null);
        if (!name.isEmpty()) requestModel.setNewName(name);
        if (!email.isEmpty()) requestModel.setNewEmail(email);
        if (!location.isEmpty()) requestModel.setNewLocation(location);
        if (!phone.isEmpty()) requestModel.setNewPhone(phone);

        this.interactor.changeRestaurantInfo(requestModel);
    }

    /**
     * Get the interactor for the controller
     *
     * @return the interactor
     */
    public ChangeRestaurantInfoInputBoundary getInteractor() {
        return interactor;
    }

    /**
     * Set the interactor for the controller
     *
     * @param interactor the interactor
     */
    public void setInteractor(ChangeRestaurantInfoInputBoundary interactor) {
        this.interactor = interactor;
    }
}
