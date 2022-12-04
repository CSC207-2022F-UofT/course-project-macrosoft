package user_homepage_use_case;

import org.bson.types.ObjectId;
import user_profile_use_case.*;
import javax.swing.*;

public class UserHomepageController {

    public JPanel getUserProfilePanel(){
        UserProfilePresenter userProfilePresenter = new UserProfileProcessor(null);
        UserProfileInputBoundary userProfileInteractor = new UserProfileInteractor(userProfilePresenter);
        UserProfileController userProfileController = new UserProfileController(userProfileInteractor, new ObjectId("63781d9deeca77407b69f2cb"));

        UserProfilePanelInterface userProfilePanel = new UserProfilePanel(userProfileController);


        userProfilePresenter.setUserProfilePanel(userProfilePanel);
        userProfilePanel.updatePanelData();

        return (JPanel)userProfilePanel;
    }
}
