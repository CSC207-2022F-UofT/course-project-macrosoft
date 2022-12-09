package user_make_review_use_case;

import org.bson.types.ObjectId;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;


public class MakeReviewController {
    MakeReviewInputBoundary reviewInteractor;
    ObjectId currentId;

    /**
     * a controller that takes in user input and sends request to interactor
     *
     * @param reviewInteractor the interactor
     * @param currentId        the current user id
     */
    public MakeReviewController(MakeReviewInputBoundary reviewInteractor, ObjectId currentId) {
        this.reviewInteractor = reviewInteractor;
        this.currentId = currentId;
    }

    /**
     * generate a request (with all the data needed) and send this request to interactor
     *
     * @param rating       the rating
     * @param comment      the comment
     * @param picPathList  the list of picture paths
     * @param subjectLine  the subject line
     * @param lastEditTime the last edit time
     */
    public void makeReview(int rating, String comment, List<Path> picPathList, String subjectLine, Date lastEditTime) {

        MakeReviewRequestModel requestMode = new MakeReviewRequestModel(currentId, rating, comment, picPathList, subjectLine, lastEditTime);

        reviewInteractor.makeReview(requestMode);
    }
}
