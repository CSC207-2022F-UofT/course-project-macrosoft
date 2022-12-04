package user_profile_use_case;

import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;

public class TempTestUserProfileScreen {

    public TempTestUserProfileScreen() {
        UserProfilePresenter userProfilePresenter = new UserProfileProcessor(null);
        UserProfileInputBoundary userProfileInteractor = new UserProfileInteractor(userProfilePresenter);
        UserProfileController userProfileController = new UserProfileController(userProfileInteractor, new ObjectId("63335e7abb6cd6599ed6f64b"));

        final JFrame frame = new JFrame();
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        UserProfilePanelInterface userProfilePanel = new UserProfilePanel(userProfileController);

        frame.add((JPanel) userProfilePanel, BorderLayout.CENTER);

        userProfilePresenter.setUserProfilePanel(userProfilePanel);
        userProfilePanel.updatePanelData();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TempTestUserProfileScreen tempTestUserProfileScreen = new TempTestUserProfileScreen();
    }
}
