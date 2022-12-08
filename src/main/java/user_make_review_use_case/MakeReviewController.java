package user_make_review_use_case;

import org.bson.types.ObjectId;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;


public class MakeReviewController {
    MakeReviewInputBoundary reviewInteractor;
    ObjectId currentId;

    public MakeReviewController(MakeReviewInputBoundary reviewInteractor, ObjectId currentId) {
        this.reviewInteractor = reviewInteractor;
        this.currentId = currentId;
    }

    public MakeReviewResponseModel makeReview(int rating, String comment, List<Path> picPathList, String subjectLine, Date lastEditTime) {

        MakeReviewRequestModel requestMode = new MakeReviewRequestModel(currentId, rating, comment, picPathList, subjectLine, lastEditTime);

        return  reviewInteractor.makeReview(requestMode);
    }
}
