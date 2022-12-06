package user_make_review_use_case;

import datamodels.MakeReviewRequestModel;
import datamodels.MakeReviewResponseModel;
import entities.Review;
import database.ReviewDataGateway;
import org.bson.types.ObjectId;


public class ReviewInteractor implements MakeReviewInputBoundary {

    ReviewDataGateway gateway;
    MakeReviewPresenter presenter;

    public ReviewInteractor(ReviewDataGateway gateway, MakeReviewPresenter presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    /**
     * rate an Order (connected by orderID) by setting a Review, overwrite that data in MongoDB
     */
    public void saveReview(Review review) {
        this.gateway.save(review);
    }

    @Override
    public MakeReviewResponseModel makeReview(MakeReviewRequestModel requestModel) {
        try {
            // create a Review object
            Review rev = new Review(new ObjectId(),
                    requestModel.getCurOrder().getOrderID(),
                    requestModel.getRating(),
                    requestModel.getComment(),
                    requestModel.getSubjectLine(),
                    requestModel.getPicPathList(),
                    requestModel.getLastEditTime());

            // save the Review to database
            this.saveReview(rev);

            // generate response
            MakeReviewResponseModel response = new MakeReviewResponseModel(rev);

            // call presenter to modify UI based on response model
            return this.presenter.prepareSuccessView(response);

        } catch (Exception e) {
            return this.presenter.prepareFailView(e.getMessage());
        }
    }

}