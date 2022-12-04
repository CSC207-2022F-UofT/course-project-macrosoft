package datamodels;

import entities.Review;

public class MakeReviewResponseModel {
    // response data model: a Review object

    Review review;

    public MakeReviewResponseModel(Review review) {
        this.review = review;
    }

    public Review getReview() {
        return review;
    }
}
