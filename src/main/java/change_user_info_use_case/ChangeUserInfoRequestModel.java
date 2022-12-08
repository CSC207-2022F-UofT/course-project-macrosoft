package change_user_info_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the request model for the change user information use case.
 */
public class ChangeUserInfoRequestModel {
    private ObjectId userId;
    private String newFirstName;
    private String newLastName;
    private String newEmail;

    /**
     * Constructor for ChangeUserInfoRequestModel
     *
     * @param userId       the user id
     * @param newFirstName the new first name of the user
     * @param newLastName  the new last name of the user
     * @param newEmail     the new email of the user
     */
    public ChangeUserInfoRequestModel(ObjectId userId, String newFirstName, String newLastName, String newEmail) {
        this.userId = userId;
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
        this.newEmail = newEmail;
    }

    /**
     * Gets the user id
     *
     * @return the user id
     */
    public ObjectId getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId the user id
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * Gets the new first name of the user
     *
     * @return the new first name of the user
     */
    public String getNewFirstName() {
        return newFirstName;
    }

    /**
     * Sets the new first name of the user
     *
     * @param newFirstName the new first name of the user
     */
    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    /**
     * Gets the new last name of the user
     *
     * @return the new last name of the user
     */
    public String getNewLastName() {
        return newLastName;
    }

    /**
     * Sets the new last name of the user
     *
     * @param newLastName the new last name of the user
     */
    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    /**
     * Gets the new email of the user
     *
     * @return the new email of the user
     */
    public String getNewEmail() {
        return newEmail;
    }

    /**
     * Sets the new email of the user
     *
     * @param newEmail the new email of the user
     */
    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
