package change_user_info_use_case;

import org.bson.types.ObjectId;

// Interface adapters layer

/**
 * This class is the controller for the change user information use case.
 */
public class ChangeUserInfoController {
    private ChangeUserInfoInputBoundary interactor;
    private final ObjectId currentUserId;

    /**
     * Constructor for ChangeUserInfoController
     *
     * @param interactor    the interactor
     * @param currentUserId the current user id
     */
    public ChangeUserInfoController(ChangeUserInfoInputBoundary interactor, ObjectId currentUserId) {
        this.interactor = interactor;
        this.currentUserId = currentUserId;
    }


    /**
     * Change the user information
     *
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     * @param email     the email of the user
     */
    public void changeUserInfo(String firstName, String lastName, String email) {
        ChangeUserInfoRequestModel requestModel = new ChangeUserInfoRequestModel(this.currentUserId, null, null, null);
        if (!firstName.isEmpty()) requestModel.setNewFirstName(firstName);
        if (!lastName.isEmpty()) requestModel.setNewLastName(lastName);
        if (!email.isEmpty()) requestModel.setNewEmail(email);

        this.interactor.changeUserInfo(requestModel);
    }

    /**
     * Gets the interactor for the controller
     *
     * @return the interactor
     */
    public ChangeUserInfoInputBoundary getInteractor() {
        return interactor;
    }

    /**
     * Sets the interactor for the controller
     *
     * @param interactor the interactor
     */
    public void setInteractor(ChangeUserInfoInputBoundary interactor) {
        this.interactor = interactor;
    }

}
