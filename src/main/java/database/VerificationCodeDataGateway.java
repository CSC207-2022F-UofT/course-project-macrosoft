package database;

import entities.VerificationCode;
import org.bson.types.ObjectId;

/**
 * Gateway for the VerificationCode entity to Database.
 */
public interface VerificationCodeDataGateway {
    /**
     * Saves a verification code to the database with the given user id
     *
     * @param userId           the id of the user
     * @param verificationCode the verification code to be saved
     */
    void save(ObjectId userId, VerificationCode verificationCode);

    /**
     * Deletes a verification code from the database with the given user id
     *
     * @param userId the id of the user
     */
    void deleteByUserId(ObjectId userId);

    /**
     * Validates and reads the verification code from the database with the given user id
     *
     * @param userId the id of the user
     * @return the verification code
     */
    VerificationCode validateAndReadByUser(ObjectId userId);

    /**
     * Updates the verification code in the database with the given user id
     *
     * @param userID           the id of the user
     * @param verificationCode the verification code to be updated
     */
    void update(ObjectId userID, VerificationCode verificationCode);
}
