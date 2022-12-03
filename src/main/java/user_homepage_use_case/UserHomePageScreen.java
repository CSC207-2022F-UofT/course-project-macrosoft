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

        final JFrame frame = new JFrame();

        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());
        frame.setLocationRelativeTo(null);

        JPanel homePanel = new JPanel();
        JPanel cartPanel = new JPanel();
        JPanel profilePanel = new JPanel();

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Home", homePanel);
        tabs.addTab("cart", cartPanel);
        tabs.addTab("Proile", profilePanel);

        frame.add(tabs);

        frame.setVisible(true);

    }
}
