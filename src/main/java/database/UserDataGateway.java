package database;

import entities.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserDataGateway {
    ObjectId newUser(String email, String firstName, String lastName);
    String save(User user);
    List<User> findAll();
    User findById(ObjectId id);
    User findByUsername(String username);
    void updateVerifiedStatus(ObjectId userId, Boolean newStatus);
    void UpdateUserInfo(ObjectId userId, String newFirstName, String newLastName, String newEmail);

    boolean getVerifiedStatus(ObjectId userId);
}
