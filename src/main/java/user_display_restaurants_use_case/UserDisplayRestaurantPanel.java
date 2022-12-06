package user_display_restaurants_use_case;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.messaging.Message;
import screens.RestaurantComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public class UserDisplayRestaurantPanel extends JPanel implements UserDisplayRestaurantPanelInterface {

    UserDisplayRestaurantController controller;
    JPanel restaurantPanel = new JPanel(new GridLayout(0, 1));

    public UserDisplayRestaurantPanel(UserDisplayRestaurantController controller) {
        this.controller = controller;

        this.setLayout(new GridLayout(0, 1));

        this.add(restaurantPanel);
    }

    public void refreshData() {
        controller.displayAllRestaurants();
    }

    public void updateRestaurantPanel(HashMap<ObjectId, String> restaurantInfo) {
        restaurantPanel = new JPanel(new GridLayout(0, 1));

        for (ObjectId restId : restaurantInfo.keySet()) {
            restaurantPanel.add(new RestaurantComponent(new JLabel(restaurantInfo.get(restId)), restId));
        }

        this.add(restaurantPanel);
    }
}
