package entities;

import org.bson.types.ObjectId;

import java.nio.file.Path;

import java.util.Date;
import java.util.List;

/**
 * This class is the review entity.
 */
public class Review {
    private final ObjectId orderID;
    private final int rating;  // 0-10
    private final String comment;
    private final List<Path> picPathList;
    private final String subjectLine;
    private final Date lastEditTime;

    /**
     * Constructor for Review
     *
     * @param reviewID     the review id
     * @param orderID      the order id
     * @param rating       the rating
     * @param comment      the comment
     * @param picPathList  the list of picture paths
     * @param subjectLine  the subject line
     * @param lastEditTime the last edit time
     */
    public Review(ObjectId reviewID, ObjectId orderID, int rating, String comment, String subjectLine, List<Path> picPathList, Date lastEditTime) {
        this.orderID = orderID;
        this.rating = rating;
        this.comment = comment;
        this.subjectLine = subjectLine;
        this.picPathList = picPathList;
        this.lastEditTime = lastEditTime;
    }

    /**
     * Gets the order id
     *
     * @return the order id
     */
    public ObjectId getOrderID() {
        return orderID;
    }

    /**
     * Gets the comment
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Gets a list of picture paths
     *
     * @return the list of picture paths
     */
    public List<Path> getPicPathList() {
        return picPathList;
    }

    /**
     * Gets the subject line
     *
     * @return the subject line
     */
    public String getSubjectLine() {
        return subjectLine;
    }

    /**
     * Gets the last edit time
     *
     * @return the last edit time
     */
    public Date getLastEditTime() {
        return lastEditTime;
    }

    /**
     * Gets the rating
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }
}
