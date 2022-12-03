package make_review_use_case;

import entities.Review;
import database.ReviewDataGateway;


public class ReviewInteractor {

    ReviewDataGateway gateway;

    public ReviewInteractor(ReviewDataGateway gateway) {
        this.gateway = gateway;
    }

    /** rate an Order (connected by orderID) by setting a Review, overwrite that data in MongoDB */
    public void setOrderReview(Review review) {
        this.gateway.save(review);
    }

}
