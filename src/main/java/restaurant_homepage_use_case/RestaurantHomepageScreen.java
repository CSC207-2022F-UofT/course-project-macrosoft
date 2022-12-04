package restaurant_homepage_use_case;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RestaurantHomepageScreen {

    RestaurantHomepageController controller;

    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color BG_LIGHT_GREEN = new Color(87, 118, 83);
    private static final Color HL_LIGHT_GREEN = new Color(166, 199, 148);
    private static final Color HL_ORANGE_YELLOW = new Color(232, 181, 93);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Color WHITE = new Color(255, 255, 255);

    private static final Border emptyBorder = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(0, 10, 0, 10);
    private static final Border blackline = BorderFactory.createLineBorder(Color.black);

    public RestaurantHomepageScreen(RestaurantHomepageController controller) {
        this.controller = controller;

        final JFrame frame = new JFrame("Restaurant Homepage");

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());
        frame.setLocationRelativeTo(null);

        JPanel homePanel = new JPanel();
        JPanel MenuPanel = new JPanel();
        JPanel profilePanel = new JPanel();

        homePanel.setOpaque(true);
        MenuPanel.setOpaque(true);
        profilePanel.setOpaque(true);

        homePanel.setBackground(GREY_WHITE);
        MenuPanel.setBackground(GREY_WHITE);
        profilePanel.setBackground(GREY_WHITE);

        JPanel greetingPanel = new JPanel();
        JLabel greetingLabel = new JLabel("Hello~ <username>");
        greetingLabel.setBackground(GREY_WHITE);
        greetingLabel.setForeground(BG_DARK_GREEN);
        greetingLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        greetingPanel.setBackground(GREY_WHITE);
        greetingPanel.setBorder(emptyBorder);
        greetingPanel.add(greetingLabel);

        homePanel.add(greetingPanel);


        JLabel reminderLabel1 = new JLabel("This page will contain the a list of orders in queue");
        JLabel reminderLabel2 = new JLabel("This page will contain the menu editing panel");
        JLabel reminderLabel3 = new JLabel("This page will contain restaurant profile page");

        homePanel.add(reminderLabel1);
        MenuPanel.add(reminderLabel2);
        profilePanel.add(reminderLabel3);

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
