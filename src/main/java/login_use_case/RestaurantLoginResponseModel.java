package login_use_case;

import org.bson.types.ObjectId;

public class RestaurantLoginResponseModel {
    private int responseCode;
    private ObjectId restaurantId;

    public RestaurantLoginResponseModel(int responseCode, ObjectId restaurantId) {
        this.responseCode = responseCode;
        this.restaurantId = restaurantId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }
}
