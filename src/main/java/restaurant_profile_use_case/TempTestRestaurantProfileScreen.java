package restaurant_profile_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;

public class TempTestRestaurantProfileScreen {
    public TempTestRestaurantProfileScreen() {
        RestaurantProfilePresenter restaurantProfilePresenter = new RestaurantProfileProcessor(null);
        RestaurantProfileInputBoundary restaurantProfileInteractor = new RestaurantProfileIneractor(restaurantProfilePresenter);
        RestaurantProfileController restaurantProfileController = new RestaurantProfileController(restaurantProfileInteractor, new ObjectId("6334a3c91b68c02450d415ba"));

        final JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        RestaurantProfilePanelInterface restaurantProfilePanel = new RestaurantProfilePanel(restaurantProfileController);

        frame.add((JPanel) restaurantProfilePanel, BorderLayout.CENTER);

        restaurantProfilePresenter.setRestaurantProfilePanel(restaurantProfilePanel);
        restaurantProfilePanel.updatePanelData();

        frame.setVisible(true);
    }
    public static void main(String[] args) {
        TempTestRestaurantProfileScreen tempTestRestaurantProfileScreen = new TempTestRestaurantProfileScreen();
    }
}
