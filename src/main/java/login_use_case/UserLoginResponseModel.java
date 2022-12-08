package login_use_case;

import org.bson.types.ObjectId;

/**
 * This class is the response model for the user login use case.
 */
public class UserLoginResponseModel {
    private int responseCode;
    private String name;
    private ObjectId userId;

    /**
     * Constructor for UserLoginResponseModel
     *
     * @param responseCode the response code
     * @param name         the name
     * @param userId       the user id
     */
    public UserLoginResponseModel(int responseCode, String name, ObjectId userId) {
        this.responseCode = responseCode;
        this.name = name;
        this.userId = userId;
    }

    /**
     * Get the response code
     *
     * @return the response code
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Gets the name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     *
     * @param userId the user id
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
