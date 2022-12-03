package database;

import entities.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserDataGateway {
    String save(User user);
    List<User> findAll();
    User findById(ObjectId id);
    User findByUsernamePassword(String username, String password);
    String updateVerifiedStatus(ObjectId userId, Boolean newStatus);
}
