package Database;

import Entities.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserDataGateway {
    String save(User user);
    List<User> findAll();
    User findById(String id);
    User findByUsernamePassword(String username, String password);
    String updateVerifiedStatus(ObjectId userId, Boolean newStatus);
}
