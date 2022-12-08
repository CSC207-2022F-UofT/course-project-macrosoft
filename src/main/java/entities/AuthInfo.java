package entities;

import org.bson.types.ObjectId;

/**
 * This class is the auth info entity.
 */
public class AuthInfo {
    private String username;
    private String password;

    private ObjectId userId;

    /**
     * Constructor for AuthInfo
     *
     * @param username the username
     * @param password the password
     * @param userId   the user id
     */
    public AuthInfo(String username, String password, ObjectId userId) {
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    /**
     * Gets the username
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
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
