package user_display_restaurants_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class UserDisplayRestaurantPanel extends JPanel implements UserDisplayRestaurantPanelInterface {

    UserDisplayRestaurantController controller;
    JPanel restaurantPanel = new JPanel(new GridLayout(0, 3));
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    JTextField searchTextBar;

    JScrollPane resScrollPanel;
    public UserDisplayRestaurantPanel(UserDisplayRestaurantController controller) {
        //initialize the controller
        this.controller = controller;

        // creating a search bar
        JPanel searchPanel = new JPanel();
        searchTextBar = new JTextField(15);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(e -> controller.searchRestaurant(searchTextBar.getText()));

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

        this.add(resScrollPanel);
    }

    public void refreshData() {
        controller.displayAllRestaurants();
    }

    /**
     * update the restaurant panel
     * @param restaurantInfo hash map, restaurant information
     */

    public void updateRestaurantPanel(HashMap<ObjectId, String> restaurantInfo) {

        restaurantPanel.removeAll();

        for (ObjectId restId : restaurantInfo.keySet()) {
            JLabel restLabel = new JLabel(restaurantInfo.get(restId));
            restLabel.setForeground(BG_DARK_GREEN);
            restLabel.setFont(new Font("Serif", Font.PLAIN, 17));
            restLabel.setHorizontalAlignment(SwingConstants.CENTER);
            restaurantPanel.add(new RestaurantComponent(restLabel, restId));
        }

        restaurantPanel.repaint();
        restaurantPanel.revalidate();
    }
}
