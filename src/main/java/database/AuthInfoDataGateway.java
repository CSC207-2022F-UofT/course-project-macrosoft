package database;

import entities.AuthInfo;
import entities.Order;
import org.bson.types.ObjectId;

/**
 * Gateway for the AuthInfo entity to Database.
 */
public interface AuthInfoDataGateway {
    /**
     * Save the AuthInfo to the database.
     * @param order the order
     * @return
     */
    String save(Order order);
    String create(String username, String password, ObjectId userId);
    AuthInfo getUserByUsernamePassword(String username, String password);
    AuthInfo getUserByUserIdPassword(ObjectId userId, String password);
    String setNewPassword(ObjectId userId, String newPassword);
    /**
     * Get the AuthInfo by the user name.
     * @param username the user name
     * @return AuthInfo the AuthInfo
     */
    AuthInfo getUserByUsername(String username);
}
