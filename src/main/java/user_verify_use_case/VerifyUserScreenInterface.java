package user_verify_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;

/**
 * interface of the screen
 */
public interface VerifyUserScreenInterface {
    /**
     * Gets the Frame of the screen
     *
     * @return the Frame of the screen
     */
    JFrame getFrame();

    /**
     * Shows the user homepage of the given user id
     *
     * @param userId the user id
     */
    void showUserHomepage(ObjectId userId);

    /**
     * Closes the screen
     */
    void close();

    /**
     * Shows a message
     *
     * @param message the message
     */
    void showMessage(String message);
}
