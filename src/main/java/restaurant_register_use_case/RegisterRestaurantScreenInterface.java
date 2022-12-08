package restaurant_register_use_case;

import javax.swing.*;

/**
 * interface of the screen
 */
public interface RegisterRestaurantScreenInterface {
    /**
     * Close.
     */
    void close();

    /**
     * Gets JFrame.
     */
    JFrame getFrame();

    /**
     * Show the welcome page.
     */
    void showWelcomePage();

    /**
     * Show message.
     *
     * @param message the message
     */
    void showMessage(String message);
}
