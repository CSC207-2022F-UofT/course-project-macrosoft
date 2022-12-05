package login_use_case;

import javax.swing.*;
import org.bson.types.ObjectId;

public interface UserLoginScreenInterface {
    void showVerifyScreen(ObjectId userId);
    void showUserHomepage(ObjectId userId);
    void showRestaurantHomepage(ObjectId restaurantId);
    void showRestaurantVerifyScreen(ObjectId restaurantId);
    void showMessage(String message);
    void close();
    JFrame getFrame();
}
