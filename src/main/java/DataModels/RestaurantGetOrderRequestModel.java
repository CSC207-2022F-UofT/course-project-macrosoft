package DataModels;

import org.bson.types.ObjectId;

public class RestaurantGetOrderRequestModel {
    private ObjectId restaurantId;

    public RestaurantGetOrderRequestModel(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }

    public ObjectId getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(ObjectId restaurantId) {
        this.restaurantId = restaurantId;
    }
}
