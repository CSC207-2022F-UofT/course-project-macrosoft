package user_homepage_use_case;

import org.bson.types.ObjectId;
import user_profile_use_case.*;
import javax.swing.*;

public class UserHomepageController {

    private ObjectId userId;

    public UserHomepageController(ObjectId userId) {
        this.userId = userId;
    }

    public JPanel getUserProfilePanel(ObjectId userId){
        UserProfilePresenter userProfilePresenter = new UserProfileProcessor(null);
        UserProfileInputBoundary userProfileInteractor = new UserProfileInteractor(userProfilePresenter);
        UserProfileController userProfileController = new UserProfileController(userProfileInteractor, userId);

        UserProfilePanelInterface userProfilePanel = new UserProfilePanel(userProfileController);


        userProfilePresenter.setUserProfilePanel(userProfilePanel);
        userProfilePanel.updatePanelData();

        return (JPanel)userProfilePanel;
    }

    public ObjectId getUserId() {
        return userId;
    }
}
