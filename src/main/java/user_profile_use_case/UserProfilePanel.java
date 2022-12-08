package user_profile_use_case;

import components.ScreenFactory;
import user_shopping_cart_use_case.ShoppingCartSingleton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class UserProfilePanel extends JPanel implements UserProfilePanelInterface {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(20, 0, 20, 0);

    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private final JLabel nameLabel = new JLabel("Name");
    private final JLabel emailLabel = new JLabel("Email");
    private final UserProfileController userProfileController;

    public UserProfilePanel(UserProfileController userProfileController) {
        this.userProfileController = userProfileController;

        this.setOpaque(true);
        this.setBackground(GREY_WHITE);
        this.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("User Profile");
        titleLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        titleLabel.setForeground(BG_DARK_GREEN);
        titlePanel.add(titleLabel);
        titlePanel.setOpaque(true);
        titlePanel.setBackground(GREY_WHITE);
        titlePanel.setBorder(emptyBorder2);

        this.add(titlePanel, BorderLayout.NORTH);

        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new GridLayout(6, 1));
        centrePanel.setOpaque(true);
        centrePanel.setBackground(BG_DARK_GREEN);

        JPanel namePanel = new JPanel();
        namePanel.setOpaque(false);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        nameLabel.setForeground(GREY_WHITE);
        namePanel.setBorder(emptyBorder3);
        namePanel.add(nameLabel);
        centrePanel.add(namePanel);

        JPanel emailPanel = new JPanel();
        emailPanel.setOpaque(false);
        emailLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        emailLabel.setForeground(GREY_WHITE);
        emailPanel.setBorder(emptyBorder3);
        emailPanel.add(emailLabel);
        centrePanel.add(emailPanel);

        JPanel containCentre = new JPanel();
        containCentre.setOpaque(false);
        containCentre.setLayout(new BorderLayout());
        containCentre.add(centrePanel, BorderLayout.CENTER);
        containCentre.setBorder(emptyBorder2);

        this.add(containCentre, BorderLayout.CENTER);

        // Add button panel
        LayoutManager gridLayout1 = new GridLayout(0,3);
        JPanel buttonsPanel = new JPanel(gridLayout1);

        JButton changeInfoButton = new JButton("Change Info");
        changeInfoButton.setOpaque(false);
        changeInfoButton.setFont(new Font("Serif", Font.BOLD, 15));
        changeInfoButton.setForeground(BG_DARK_GREEN);
        changeInfoButton.addActionListener(new ActionListener() {
            /**
             * make a new change user info screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangeUserInfoScreen();
            }
        });
        buttonsPanel.add(changeInfoButton);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setOpaque(false);
        changePasswordButton.setFont(new Font("Serif", Font.BOLD, 15));
        changePasswordButton.setForeground(BG_DARK_GREEN);
        changePasswordButton.addActionListener(new ActionListener() {
            /**
             * make a new change password screen
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangePasswordScreen();
            }
        });
        buttonsPanel.add(changePasswordButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setOpaque(false);
        logoutButton.setFont(new Font("Serif", Font.BOLD, 15));
        logoutButton.setForeground(BG_DARK_GREEN);
        logoutButton.addActionListener(new ActionListener() {
            /**
             * logout of the current account
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        buttonsPanel.add(logoutButton);

        buttonsPanel.setBorder(emptyBorder2);
        buttonsPanel.setOpaque(false);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }


    /**
     * @param newName new name to change
     */
    @Override
    public void updateNameLabel(String newName) {
        nameLabel.setText(newName);
    }

    /**
     *
     * @param newEmail new email to change
     */
    @Override
    public void updateEmailLabel(String newEmail) {
        emailLabel.setText(newEmail);
    }

    /**
     * update the panel data
     */
    @Override
    public void updatePanelData() {
        userProfileController.getUserProfile();
    }

    /**
     * make a new change password screen
     */

    public void showChangePasswordScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createChangePasswordScreen(userProfileController.getCurrentUserId());
    }

    /**
     * make a new change user info screen
     */

    public void showChangeUserInfoScreen() {
        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createChangeUserInfoScreen(userProfileController.getCurrentUserId());
    }

    /**
     * logout of the current user
     */

    public void logout() {
        ShoppingCartSingleton.setSingletonInstance(new ShoppingCartSingleton(null, new HashMap<>()));

        java.awt.Window[] win = java.awt.Window.getWindows();
        for (Window window : win) {
            window.dispose();
        }

        ScreenFactory screenFactory = new ScreenFactory();
        screenFactory.createWelcomeScreen();
    }
}
