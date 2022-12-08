package restaurant_verify_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;

/**
 * interface of the screen
 */
public interface VerifyResScreenInterface {
    /**
     * Gets the JFrame of the screen.
     */
    JFrame getFrame();

    /**
     * Shows the login screen.
     */
    void showLoginScreen();

    /**
     * Shows the restaurant home page.
     */
    void showRestaurantHomePage(ObjectId restaurantId, String restaurantName);

    /**
     * Closes the screen.
     */
    void close();

    /**
     * Shows a message.
     *
     * @param message the message
     */
    void showMessage(String message);
}
