package database;

import entities.AuthInfo;
import entities.Order;
import org.bson.types.ObjectId;

public interface AuthInfoDataGateway {
    String save(Order order);
    String delete(Order order);
    String create(String username, String password, ObjectId userId);
    AuthInfo getUserByUsernamePassword(String username, String password);
    AuthInfo getUserByUserIdPassword(ObjectId userId, String password);
    String setNewPassword(ObjectId userId, String newPassword);
    AuthInfo getUserByUsername(String username);
}
