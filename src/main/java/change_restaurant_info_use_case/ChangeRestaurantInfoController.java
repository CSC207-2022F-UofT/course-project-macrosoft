package change_restaurant_info_use_case;

import org.bson.types.ObjectId;

// Interface adapters layer

/**
 * This class is the controller for the change restaurant info use case.
 */
public class ChangeRestaurantInfoController {
    private ChangeRestaurantInfoInputBoundary interactor;
    private final ObjectId currentRestaurantId;

    public ChangeRestaurantInfoController(ChangeRestaurantInfoInputBoundary interactor, ObjectId currentRestaurantId) {
        this.interactor = interactor;
        this.currentRestaurantId = currentRestaurantId;
    }

    /**
     * Makes the given information into a request model, and calls the interactor to process the request model.
     * @param name new name
     * @param email new email
     * @param location new location
     * @param phone new phone
     */
    public void changeRestaurantInfo(String name, String email, String location, String phone) {
        ChangeRestaurantInfoRequestModel requestModel = new ChangeRestaurantInfoRequestModel(this.currentRestaurantId, null, null, null, null);
        if (!name.isEmpty()) requestModel.setNewName(name);
        if (!email.isEmpty()) requestModel.setNewEmail(email);
        if (!location.isEmpty()) requestModel.setNewLocation(location);
        if (!phone.isEmpty()) requestModel.setNewPhone(phone);

        this.interactor.changeRestaurantInfo(requestModel);
    }

    public ChangeRestaurantInfoInputBoundary getInteractor() {
        return interactor;
    }

    public void setInteractor(ChangeRestaurantInfoInputBoundary interactor) {
        this.interactor = interactor;
    }

}
