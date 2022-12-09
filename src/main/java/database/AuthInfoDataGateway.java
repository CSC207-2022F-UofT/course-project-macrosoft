package database;

import entities.AuthInfo;
import entities.Order;
import org.bson.types.ObjectId;

/**
 * Gateway for the AuthInfo entity to Database.
 */
public interface AuthInfoDataGateway {
    /**
     * Creates a new authentication information
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param userId  the id of the user
     */
    void create(String username, String password, ObjectId userId);

    /**
     * Gets user by username and password
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the user
     */
    AuthInfo getUserByUsernamePassword(String username, String password);

    /**
     * Get user by user id and password
     *
     * @param userId   the id of the user
     * @param password the password of the user
     * @return the user
     */
    AuthInfo getUserByUserIdPassword(ObjectId userId, String password);

    /**
     * Sets a new password for a user
     *
     * @param userId      the id of the user
     * @param newPassword the new password
     * @return a string shows the result
     */
    String setNewPassword(ObjectId userId, String newPassword);

    /**
     * Gets user by username
     *
     * @param username the username of the user
     * @return the user
     */
    AuthInfo getUserByUsername(String username);

    void removeByUsername(String username);
}
