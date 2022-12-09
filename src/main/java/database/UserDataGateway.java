package database;

import entities.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserDataGateway {
    /**
     * Creates a new user
     *
     * @param email     the email of the user
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     * @return the id of the new user
     */
    ObjectId newUser(String email, String firstName, String lastName);

    /**
     * Gets a user from the database by id
     *
     * @param id the id of the user
     * @return the user
     */
    User findById(ObjectId id);

    /**
     * Updates verified status of a user
     *
     * @param userId    the id of the user
     * @param newStatus the new status
     */
    void updateVerifiedStatus(ObjectId userId, Boolean newStatus);

    /**
     * Updates the information of a user
     *
     * @param newFirstName the new first name
     * @param newLastName  the new last name
     * @param newEmail     the new email
     */
    void UpdateUserInfo(ObjectId userId, String newFirstName, String newLastName, String newEmail);

}
