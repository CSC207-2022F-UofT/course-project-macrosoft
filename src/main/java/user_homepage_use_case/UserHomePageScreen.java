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

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public UserHomePageScreen(UserHomepageController controller) {
        this.controller = controller;

        final JFrame frame = new JFrame("User Homepage");

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());
        frame.setLocationRelativeTo(null);

        JPanel homePanel = new JPanel();
        JPanel cartPanel = new JPanel();
        JPanel orderHistoryPanel = new JPanel();
        JPanel profilePanel = new JPanel();

        homePanel.setOpaque(true);
        cartPanel.setOpaque(true);
        profilePanel.setOpaque(true);
        orderHistoryPanel.setOpaque(true);

        homePanel.setBackground(GREY_WHITE);
        cartPanel.setBackground(GREY_WHITE);
        profilePanel.setBackground(GREY_WHITE);
        orderHistoryPanel.setBackground(GREY_WHITE);

        JPanel greetingPanel = new JPanel();
        JLabel greetingLabel = new JLabel("Hello");
        greetingLabel.setBackground(GREY_WHITE);
        greetingLabel.setForeground(BG_DARK_GREEN);
        greetingLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        greetingPanel.setBackground(GREY_WHITE);
        greetingPanel.setBorder(emptyBorder);
        greetingPanel.add(greetingLabel);

        orderHistoryPanel.setLayout(new BorderLayout());

        homePanel.add(greetingPanel);
        profilePanel.add(controller.getUserProfilePanel(controller.getUserId()));
        orderHistoryPanel.add(controller.getUserOrderHistoryPanel(controller.getUserId()));

        JLabel reminderLabel1 = new JLabel("This page will contain the search bar and a list of restaurants");
        JLabel reminderLabel2 = new JLabel("This page will contain the shopping cart(items in cart)");
        JLabel reminderLabel3 = new JLabel("This page will contain user profile page");
        homePanel.add(reminderLabel1);
        homePanel.add(controller.getUserDisplayRestaurantsPanel(controller.getUserId()));
        cartPanel.add(controller.getShoppingCartPanel());
        profilePanel.add(reminderLabel3);

        UIManager.put("TabbedPane.selected", Color.red);

        JLabel homeLabel = new JLabel("Home");
        homeLabel.setPreferredSize(new Dimension(20, 10));

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
