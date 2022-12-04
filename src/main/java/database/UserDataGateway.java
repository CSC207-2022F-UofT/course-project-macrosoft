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
    void UpdateUserInfo(ObjectId userId, String newFirstName, String newLastName, String newEmail);

    boolean getVerifiedStatus(ObjectId userId);
}
