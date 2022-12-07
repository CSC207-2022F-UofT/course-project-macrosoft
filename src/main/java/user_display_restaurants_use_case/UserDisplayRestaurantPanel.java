package user_display_restaurants_use_case;

import login_use_case.*;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    JTextField searchTextBar;

    JScrollPane resScrollPanel;
    public UserDisplayRestaurantPanel(UserDisplayRestaurantController controller) {
        this.controller = controller;

        JPanel searchPanel = new JPanel();
        searchTextBar = new JTextField(15);
        JButton searchButton = new JButton();

        searchButton.addActionListener(e -> {
            controller.searchRestaurant(searchTextBar.getText());
        });

        searchPanel.add(searchTextBar);
        searchPanel.add(searchButton);

        searchPanel.setMaximumSize(new Dimension(this.getWidth(), 50));

        restaurantPanel.setOpaque(true);
        restaurantPanel.setBackground(GREY_WHITE);

        this.setLayout(new BorderLayout());

        this.add(searchPanel, BorderLayout.NORTH);

        resScrollPanel = new JScrollPane(restaurantPanel);
        resScrollPanel.setOpaque(true);
        resScrollPanel.setBackground(GREY_WHITE);
        restaurantPanel.setBackground(GREY_WHITE);
        resScrollPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        resScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

    public void refreshData() {
        controller.displayAllRestaurants();
    }

    public void updateRestaurantPanel(HashMap<ObjectId, String> restaurantInfo) {

        restaurantPanel.removeAll();

        for (ObjectId restId : restaurantInfo.keySet()) {
            JLabel restLabel = new JLabel(restaurantInfo.get(restId));
            restLabel.setForeground(BG_DARK_GREEN);
            restLabel.setFont(new Font("Serif", Font.PLAIN, 17));
            restLabel.setHorizontalAlignment(SwingConstants.CENTER);
//            restLabel.setAlignmentX(CENTER_ALIGNMENT);
            restaurantPanel.add(new RestaurantComponent(restLabel, restId));
        }

        restaurantPanel.repaint();
        restaurantPanel.revalidate();
    }
}
