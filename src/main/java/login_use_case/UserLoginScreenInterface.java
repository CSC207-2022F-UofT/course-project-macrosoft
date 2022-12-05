package login_use_case;

import javax.swing.*;
import org.bson.types.ObjectId;

public interface UserLoginScreenInterface {
    void showVerifiedScreen();
    void showUserHomepage(ObjectId userId);
    void showRestaurantHomepage(ObjectId restaurantId);
    void close();
    JFrame getFrame();
}
