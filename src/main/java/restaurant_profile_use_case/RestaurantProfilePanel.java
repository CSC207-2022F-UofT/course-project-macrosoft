package restaurant_profile_use_case;

import change_password_use_case.*;
import change_user_info_use_case.*;
import user_profile_use_case.UserProfileController;
import user_profile_use_case.UserProfilePanelInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantProfilePanel extends JPanel implements RestaurantProfilePanelInterface {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(200, 0, 20, 0);

    private JLabel nameLabel = new JLabel("Name");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel locationLabel = new JLabel("Location");
    private JLabel phoneLabel = new JLabel("Phone");
    private RestaurantProfoleController restaurantProfoleController;

    public RestaurantProfilePanel(RestaurantProfoleController restaurantProfoleController) {
        this.restaurantProfoleController = restaurantProfoleController;

        GridLayout gridLayout = new GridLayout(0,1);

        JPanel centrePanel = new JPanel(gridLayout);
        centrePanel.setOpaque(false);
        nameLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        nameLabel.setForeground(GREY_WHITE);
        nameLabel.setBorder(emptyBorder3);
        centrePanel.add(nameLabel);
        emailLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        emailLabel.setForeground(GREY_WHITE);
        emailLabel.setBorder(emptyBorder3);
        centrePanel.add(emailLabel);
        locationLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        locationLabel.setForeground(GREY_WHITE);
        locationLabel.setBorder(emptyBorder3);
        centrePanel.add(locationLabel);
        phoneLabel.setFont(new Font("Serif", Font.BOLD|Font.ITALIC, 40));
        phoneLabel.setForeground(GREY_WHITE);
        phoneLabel.setBorder(emptyBorder3);
        centrePanel.add(phoneLabel);

        this.add(centrePanel, BorderLayout.CENTER);

        // Add button panel
        LayoutManager gridLayout1 = new GridLayout(0,2);
        JPanel buttonsPanel = new JPanel(gridLayout1);

        JButton changeInfoButton = new JButton("Change Info");
        changeInfoButton.setOpaque(false);
        changeInfoButton.setFont(new Font("Serif", Font.BOLD, 15));
        changeInfoButton.setForeground(BG_DARK_GREEN);
        changeInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangeRestaurantInfoScreen();
            }
        });
        buttonsPanel.add(changeInfoButton);

        JButton changePasswordPanel = new JButton("Change Password");
        changePasswordPanel.setOpaque(false);
        changePasswordPanel.setFont(new Font("Serif", Font.BOLD, 15));
        changePasswordPanel.setForeground(BG_DARK_GREEN);
        changePasswordPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangePasswordScreen();
            }
        });
        buttonsPanel.add(changePasswordPanel);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updateNameLabel(String newName) {
        nameLabel.setText(newName);
    }

    @Override
    public void updateEmailLabel(String newEmail) {
        emailLabel.setText(newEmail);
    }

    @Override
    public void updateLocationLabel(String newLocation) {
        locationLabel.setText(newLocation);
    }

    @Override
    public void updatePhoneLabel(String newPhone) {
        phoneLabel.setText(newPhone);
    }

    @Override
    public void updatePanelData() {
        RestaurantProfoleController.c();
    }

    public void showChangePasswordScreen() {
        ChangePasswordPresenter changePasswordPresenter = new ChangePasswordProcessor(null);
        ChangePasswordInputBoundary changePasswordInputBoundary = new ChangePasswordInteractor(changePasswordPresenter);
        ChangePasswordController changePasswordController = new ChangePasswordController(
                changePasswordInputBoundary,
                userProfileController.getCurrentUserId());

        ChangePasswordScreenInterface changePasswordScreen = new ChangePasswordScreen(changePasswordController);

        changePasswordPresenter.setChangePasswordScreenInterface(changePasswordScreen);

        changePasswordScreen.getFrame().setVisible(true);
    }

    public void showChangeRestaurantInfoScreen() {
        ChangeRestaurantInfoPresenter changeRestaurantInfoPresenter = new ChangeRestaurantInfoPresenter(null);
        ChangeRestaurantInfoInputBoundary changeRestaurantInfoInputBoundary = new ChangeRestaurantInfoInputBoundary(changeRestaurantInfoPresenter);
        ChangeUserInfoController changeUserInfoController = new ChangeUserInfoController(
                changeRestaurantInfoInputBoundary,
                restaurantProfoleController.getCurrentRestaurantId());

        ChangeRestaurantInfoScreenInterface changeRestaurantInfoScreen = new ChangeRestaurantInfoScreen(changeRestaurantInfoController);

        changeRestaurantInfoPresenter.setScreen(changeRestaurantInfoScreen);

        changeRestaurantInfoScreen.getFrame().setVisible(true);
    }
}
