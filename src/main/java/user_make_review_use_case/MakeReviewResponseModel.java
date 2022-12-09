package user_make_review_use_case;

/**
 * This class is the response model of the make review use case.
 */
public class MakeReviewResponseModel {
    // response data model: a Review object

    String reviewId;

    /**
     * Constructor of MakeReviewResponseModel
     *
     * @param reviewId review id
     */
    public MakeReviewResponseModel(String reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * Gets the review id
     *
     * @return the review id
     */
    public String getReviewId() {
        return reviewId;
    }
}
