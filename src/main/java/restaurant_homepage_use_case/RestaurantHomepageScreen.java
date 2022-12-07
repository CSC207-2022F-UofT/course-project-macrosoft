package restaurant_homepage_use_case;

import javax.swing.*;
import java.awt.*;

public class RestaurantHomepageScreen {

    RestaurantHomepageController controller;
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);

    public RestaurantHomepageScreen(RestaurantHomepageController controller, String restaurantName) {

        // initialize the controller
        this.controller = controller;

        // initialize a frame
        final JFrame frame = new JFrame("Restaurant Homepage");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // 3 different panels for different components
        JPanel homePanel = new JPanel();
        JPanel MenuPanel = new JPanel();
        JPanel profilePanel = new JPanel();

        // color of the panels
        homePanel.setOpaque(true);
        MenuPanel.setOpaque(true);
        profilePanel.setOpaque(true);
        homePanel.setBackground(GREY_WHITE);
        MenuPanel.setBackground(GREY_WHITE);
        profilePanel.setBackground(GREY_WHITE);

        homePanel.setLayout(new BorderLayout());
        MenuPanel.setLayout(new BorderLayout());
        profilePanel.setLayout(new BorderLayout());

        // add screens to the home screen
        homePanel.add(controller.getRestaurantOrderHistoryPanel(restaurantName), BorderLayout.CENTER);
        MenuPanel.add(controller.getMenuPanel(controller.getCurrentRestaurantId()), BorderLayout.CENTER);
        profilePanel.add(controller.getRestaurantProfilePanel(controller.getCurrentRestaurantId()), BorderLayout.CENTER);

        // create a new tabbed pane, each panel corresponds to a tap
        JTabbedPane tabs = new JTabbedPane();
        tabs.setOpaque(true);
        tabs.setBackground(BG_DARK_GREEN);
        tabs.setForeground(GREY_WHITE);

        tabs.addTab("Home", homePanel);
        tabs.addTab("Menu", MenuPanel);
        tabs.addTab("Profile", profilePanel);

        tabs.setTabPlacement(JTabbedPane.BOTTOM);
        frame.add(tabs);
        frame.setVisible(true);
    }
}
