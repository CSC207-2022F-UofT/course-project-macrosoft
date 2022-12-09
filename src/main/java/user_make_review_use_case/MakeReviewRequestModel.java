package user_make_review_use_case;

import org.bson.types.ObjectId;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

/**
 * This class is the request model for make review use case.
 */
public class MakeReviewRequestModel {
    ObjectId curOrder;

    private final int rating;  // 0-10
    private final String comment;
    private final List<Path> picPathList;
    private final String subjectLine;
    private final Date lastEditTime;

    /**
     * Constructor for MakeReviewRequestModel
     *
     * @param curOrder     the current order id
     * @param rating       the rating
     * @param comment      the comment
     * @param picPathList  the list of picture paths
     * @param subjectLine  the subject line
     * @param lastEditTime the last edit time
     */
    public MakeReviewRequestModel(ObjectId curOrder, int rating, String comment, List<Path> picPathList, String subjectLine, Date lastEditTime) {
        this.curOrder = curOrder;
        this.rating = rating;
        this.comment = comment;
        this.picPathList = picPathList;
        this.subjectLine = subjectLine;
        this.lastEditTime = lastEditTime;
    }

    /**
     * Gets the current order id
     *
     * @return the current order id
     */
    public ObjectId getCurOrder() {
        return curOrder;
    }

    /**
     * Gets the rating
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
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
     * Gets the list of picture paths
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
}
