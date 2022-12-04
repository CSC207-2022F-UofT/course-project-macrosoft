package change_user_info_use_case;

import org.bson.types.ObjectId;

public class ChangeUserInfoController {
    private ChangeUserInfoInputBoundary interactor;
    private ObjectId currentUserId;

    public ChangeUserInfoController(ChangeUserInfoInputBoundary interactor, ObjectId currentUserId) {
        this.interactor = interactor;
        this.currentUserId = currentUserId;
    }



    public void changeUserInfo(String firstName, String lastName, String email) {
        ChangeUserInfoRequestModel requestModel = new ChangeUserInfoRequestModel(this.currentUserId, null, null, null);
        if (!firstName.isEmpty()) requestModel.setNewFirstName(firstName);
        if (!lastName.isEmpty()) requestModel.setNewLastName(lastName);
        if (!email.isEmpty()) requestModel.setNewEmail(email);

        this.interactor.changeUserInfo(requestModel);
    }

    public ChangeUserInfoInputBoundary getInteractor() {
        return interactor;
    }

    public void setInteractor(ChangeUserInfoInputBoundary interactor) {
        this.interactor = interactor;
    }

    public ObjectId getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(ObjectId currentUserId) {
        this.currentUserId = currentUserId;
    }
}
