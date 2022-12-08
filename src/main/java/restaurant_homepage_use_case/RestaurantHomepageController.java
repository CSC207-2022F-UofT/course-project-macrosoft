package restaurant_homepage_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;

import javax.swing.*;

public class RestaurantHomepageController {
    ObjectId currentRestaurantId;

    public RestaurantHomepageController(ObjectId currentRestaurantId) {
        this.currentRestaurantId = currentRestaurantId;
    }

    public JPanel getRestaurantOrderHistoryPanel(String restaurantName) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createRestaurantOrderHistoryPanel(currentRestaurantId, restaurantName);
    }

    public JPanel getRestaurantProfilePanel(ObjectId currentRestaurantId) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createRestaurantProfilePanel(currentRestaurantId);
    }

    public JPanel getMenuPanel(ObjectId currentRestaurantId){
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createRestaurantDisplayMenuPanel(currentRestaurantId);
    }

    public ObjectId getCurrentRestaurantId() {
        return currentRestaurantId;
    }
}
