package restaurant_homepage_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;

import javax.swing.*;

/**
 * This class is the controller for the restaurant homepage use case.
 */
public class RestaurantHomepageController {
    ObjectId currentRestaurantId;

    /**
     * Constructor for RestaurantHomepageController
     *
     * @param currentRestaurantId the current restaurant id
     */
    public RestaurantHomepageController(ObjectId currentRestaurantId) {
        this.currentRestaurantId = currentRestaurantId;
    }

    /**
     * Gets the restaurant order history panel for the current restaurant.
     *
     * @param restaurantName the name of the current restaurant
     * @return the restaurant order history panel
     */
    public JPanel getRestaurantOrderHistoryPanel(String restaurantName) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createRestaurantOrderHistoryPanel(currentRestaurantId, restaurantName);
    }

    /**
     * Gets the restaurant profile panel for the current restaurant.
     *
     * @param currentRestaurantId the id of the current restaurant
     * @return the restaurant profile panel
     */
    public JPanel getRestaurantProfilePanel(ObjectId currentRestaurantId) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createRestaurantProfilePanel(currentRestaurantId);
    }

    /**
     * Gets the restaurant menu panel for the current restaurant.
     *
     * @param currentRestaurantId the id of the current restaurant
     * @return the restaurant menu panel
     */
    public JPanel getMenuPanel(ObjectId currentRestaurantId) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createRestaurantDisplayMenuPanel(currentRestaurantId);
    }

    /**
     * Gets the current restaurant id.
     *
     * @return the current restaurant id
     */
    public ObjectId getCurrentRestaurantId() {
        return currentRestaurantId;
    }
}
