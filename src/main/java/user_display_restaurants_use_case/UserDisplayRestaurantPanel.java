package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;

public class UserDisplayRestaurantPanel extends JPanel implements UserDisplayRestaurantPanelInterface {

    UserDisplayRestaurantController controller;

    JPanel restaurantPanel = new JPanel(new GridLayout(0, 3));

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public UserDisplayRestaurantPanel(UserDisplayRestaurantController controller) {
        this.controller = controller;

        this.setLayout(new GridLayout(0, 1));
        restaurantPanel.setOpaque(true);
        restaurantPanel.setBackground(GREY_WHITE);

//        this.add(restaurantPanel);
    }

    public void refreshData() {
        controller.displayAllRestaurants();
    }

    public void updateRestaurantPanel(HashMap<ObjectId, String> restaurantInfo) {

        restaurantPanel = new JPanel(new GridLayout(0, 3));
        restaurantPanel.setOpaque(true);
        restaurantPanel.setBackground(GREY_WHITE);
        restaurantPanel.setBorder(emptyBorder);

        for (ObjectId restId : restaurantInfo.keySet()) {
            JLabel restLabel = new JLabel(restaurantInfo.get(restId));
            restLabel.setForeground(BG_DARK_GREEN);
            restLabel.setFont(new Font("Serif", Font.PLAIN, 17));
            restLabel.setHorizontalAlignment(SwingConstants.CENTER);
//            restLabel.setAlignmentX(CENTER_ALIGNMENT);
            restaurantPanel.add(new RestaurantComponent(restLabel, restId));
        }


        JScrollPane resScrollPanel = new JScrollPane(restaurantPanel);
        resScrollPanel.setOpaque(true);
        resScrollPanel.setBackground(GREY_WHITE);
        restaurantPanel.setBackground(GREY_WHITE);
        resScrollPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        resScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(resScrollPanel);
    }
}
