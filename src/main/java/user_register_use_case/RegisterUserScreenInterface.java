package user_register_use_case;

import javax.swing.*;

/**
 * interface of the screen
 * the RegisterUserScreen implements it
 */
public interface RegisterUserScreenInterface {
    /**
     * Close the screen
     */
    void close();

    /**
     * Get the Frame of the screen
     */
    JFrame getFrame();

    /**
     * Show the welcome page
     */
    void showWelcomePage();

    /**
     * Show a message
     *
     * @param message message to show
     */
    void showMessage(String message);
}
