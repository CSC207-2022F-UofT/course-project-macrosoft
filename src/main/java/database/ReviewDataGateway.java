package database;

import entities.Review;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Gateway for the Review entity to Database.
 */
public interface ReviewDataGateway {
    /**
     * Saves a review to the database
     *
     * @param review the review to be saved
     * @return the id of the review
     */
    String save(Review review);

    /**
     * Finds a review by id
     *
     * @param id the id of a review
     * @return the review with the given id
     */
    Review findById(ObjectId id);

    /**
     * Finds a review by its linked orderId
     * @param id orderId
     * @return the review with the given orderId
     */
    Review findByOrderId(ObjectId id);

}
