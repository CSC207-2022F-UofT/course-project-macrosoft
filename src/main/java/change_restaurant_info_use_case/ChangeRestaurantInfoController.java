package change_restaurant_info_use_case;

import org.bson.types.ObjectId;

// Interface adapters layer

/**
 * This class is the controller for the change restaurant info use case.
 */
public class ChangeRestaurantInfoController {
    private ChangeRestaurantInfoInputBoundary interactor;
    private ObjectId currentRestaurantId;

    public ChangeRestaurantInfoController(ChangeRestaurantInfoInputBoundary interactor, ObjectId currentRestaurantId) {
        this.interactor = interactor;
        this.currentRestaurantId = currentRestaurantId;
    }



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

    public ObjectId getCurrentRestaurantId() {
        return currentRestaurantId;
    }

    public void setCurrentRestaurantId(ObjectId currentRestaurantId) {
        this.currentRestaurantId = currentRestaurantId;
    }
}
