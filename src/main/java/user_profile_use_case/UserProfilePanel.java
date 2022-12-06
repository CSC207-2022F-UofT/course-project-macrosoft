package user_profile_use_case;

import change_password_use_case.*;
import change_user_info_use_case.*;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfilePanel extends JPanel implements UserProfilePanelInterface {
    private static final Color BG_DARK_GREEN =  new Color(38, 73, 65);
    private static final Color GREY_WHITE = new Color(214, 210, 205);
    private static final Border emptyBorder3 = BorderFactory.createEmptyBorder(20, 0, 20, 0);

    private static final Border emptyBorder2 = BorderFactory.createEmptyBorder(30, 30, 30, 30);
    private JLabel nameLabel = new JLabel("Name");
    private JLabel emailLabel = new JLabel("Email");
    private UserProfileController userProfileController;

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
        LayoutManager gridLayout1 = new GridLayout(0,2);
        JPanel buttonsPanel = new JPanel(gridLayout1);

        JButton changeInfoButton = new JButton("Change Info");
        changeInfoButton.setOpaque(false);
        changeInfoButton.setFont(new Font("Serif", Font.BOLD, 15));
        changeInfoButton.setForeground(BG_DARK_GREEN);
        changeInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChangeUserInfoScreen();
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

        buttonsPanel.setBorder(emptyBorder2);
        buttonsPanel.setOpaque(false);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }


    /**
     * @param newName
     */
    @Override
    public void updateNameLabel(String newName) {
        nameLabel.setText(newName);
    }
    @Override
    public void updateEmailLabel(String newEmail) {
        emailLabel.setText(newEmail);
    }
    @Override
    public void updatePanelData() {
        userProfileController.getUserProfile();
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

    public void showChangeUserInfoScreen() {
        ChangeUserInfoPresenter changeUserInfoPresenter = new ChangeUserInfoProcessor(null);
        ChangeUserInfoInputBoundary changeUserInfoInputBoundary = new ChangeUserInfoInteractor(changeUserInfoPresenter);
        ChangeUserInfoController changeUserInfoController = new ChangeUserInfoController(
                changeUserInfoInputBoundary,
                userProfileController.getCurrentUserId());

        ChangeUserInfoScreenInterface changeUserInfoScreen = new ChangeUserInfoScreen(changeUserInfoController);

        changeUserInfoPresenter.setScreen(changeUserInfoScreen);

        changeUserInfoScreen.getFrame().setVisible(true);
    }
}
