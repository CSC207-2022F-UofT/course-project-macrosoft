package user_make_review_use_case;

public class MakeReviewResponseModel {
    // response data model: a Review object

    String reviewId;

    public MakeReviewResponseModel(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }
}
