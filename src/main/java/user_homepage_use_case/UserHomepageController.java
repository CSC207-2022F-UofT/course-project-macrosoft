package user_homepage_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;

import javax.swing.*;

/**
 * This class is the controller of the user homepage.
 */
public class UserHomepageController {

    private final ObjectId userId;

    /**
     * Constructor for UserHomepageController
     *
     * @param userId user id
     */
    public UserHomepageController(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * Gets user profile panel by its id
     *
     * @param userId the user id
     */
    public JPanel getUserProfilePanel(ObjectId userId) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createUserProfilePanel(userId);
    }

    /**
     * Gets user order history panel by its id
     *
     * @param userId the user id
     * @return the user order history panel
     */
    public JPanel getUserOrderHistoryPanel(ObjectId userId) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createUserOrderHistoryPanel(userId);
    }

    /**
     * Gets user display restaurant panel by its id
     *
     * @param userId the user id
     * @return the user display restaurant panel
     */
    public JPanel getUserDisplayRestaurantsPanel(ObjectId userId) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createUserDisplayRestaurantsPanel(userId);
    }

    /**
     * Gets the shopping cart panel by its id
     *
     * @return the shopping cart panel
     */
    public JPanel getShoppingCartPanel() {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.getShoppingCartPanel(userId);
    }

    /**
     * Gets the user id
     *
     * @return the user id
     */
    public ObjectId getUserId() {
        return userId;
    }
}
