package Database;

import Entities.User;

import java.util.List;

public interface UserDataGateway {
    String save(User user);
    List<User> findAll();
    User findById(String id);
    User findByUsernamePassword(String username, String password);
}
