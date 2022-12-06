package user_homepage_use_case;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UserHomePageScreen {
    UserHomepageController controller;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(50, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public UserHomePageScreen(UserHomepageController controller) {
        this.controller = controller;

        // set up the frame.
        final JFrame frame = new JFrame("User Homepage");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // create the panels of each tab
        JPanel homePanel = new JPanel();
        JPanel cartPanel = new JPanel();
        JPanel orderHistoryPanel = new JPanel();
        JPanel profilePanel = new JPanel();

        // set the background color of the panels
        homePanel.setOpaque(true);
        cartPanel.setOpaque(true);
        profilePanel.setOpaque(true);
        orderHistoryPanel.setOpaque(true);
        homePanel.setBackground(GREY_WHITE);
        cartPanel.setBackground(GREY_WHITE);
        profilePanel.setBackground(GREY_WHITE);
        orderHistoryPanel.setBackground(GREY_WHITE);

        //set the layout of the panels
        homePanel.setLayout(new BorderLayout());
        orderHistoryPanel.setLayout(new BorderLayout());
        profilePanel.setLayout(new BorderLayout());

        //the greeting message on the first page
        JPanel greetingPanel = new JPanel();
        JLabel greetingLabel = new JLabel("Pick Your Favourite Restaurant! ");
        greetingLabel.setBackground(GREY_WHITE);
        greetingLabel.setForeground(BG_DARK_GREEN);
        greetingLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        greetingPanel.setBackground(GREY_WHITE);
        greetingPanel.setBorder(emptyBorder);
        greetingPanel.add(greetingLabel);

        homePanel.add(greetingPanel, BorderLayout.NORTH);
        homePanel.add(controller.getUserDisplayRestaurantsPanel(controller.getUserId()), BorderLayout.CENTER);
        profilePanel.add(controller.getUserProfilePanel(controller.getUserId()));
        orderHistoryPanel.add(controller.getUserOrderHistoryPanel(controller.getUserId()));
        cartPanel.add(controller.getShoppingCartPanel());

        JTabbedPane tabs = new JTabbedPane();
        tabs.setOpaque(true);
        tabs.setBackground(BG_DARK_GREEN);
        tabs.setForeground(GREY_WHITE);

        tabs.addTab("Home", homePanel);
        tabs.addTab("Cart", cartPanel);
        tabs.addTab("Order History", orderHistoryPanel);
        tabs.addTab("Profile", profilePanel);

        tabs.setTabPlacement(JTabbedPane.BOTTOM);
        frame.add(tabs);
        frame.setVisible(true);
    }
}
