package login_use_case;

import javax.swing.*;

import org.bson.types.ObjectId;

/**
 * The interface of the user login screen
 */

public interface UserLoginScreenInterface {
    /**
     * Shows the verify screen by the user id
     *
     * @param userId the user id
     */
    void showVerifyScreen(ObjectId userId);

    /**
     * Shows the user home page screen by the user id
     *
     * @param userId the user id
     */
    void showUserHomepage(ObjectId userId);

    /**
     * Shows the restaurant home page screen by the restaurant id and restaurant name
     *
     * @param restaurantId   the restaurant id
     * @param restaurantName the restaurant name
     */
    void showRestaurantHomepage(ObjectId restaurantId, String restaurantName);

    /**
     * Shows the restaurant verify screen by the restaurant id
     *
     * @param restaurantId the restaurant id
     */
    void showRestaurantVerifyScreen(ObjectId restaurantId);

    /**
     * Shows the message
     *
     * @param message the message
     */
    void showMessage(String message);

    /**
     * Closes the screen
     */
    void close();

    /**
     * Gets the Frame
     */
    JFrame getFrame();
}
