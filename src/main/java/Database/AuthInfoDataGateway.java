package Database;

import Entities.AuthInfo;
import Entities.Order;

public interface AuthInfoDataGateway {
    String save(Order order);
    String delete(Order order);
    String create(Order order);
    AuthInfo getUserByUsernamePassword(String username, String password);
}
