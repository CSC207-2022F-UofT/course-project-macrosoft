package user_make_review_use_case;

import database.MongoCollectionFetcher;
import database.ReviewDataProcessorMongo;
import entities.Review;
import database.ReviewDataGateway;
import org.bson.types.ObjectId;


public class ReviewInteractor implements MakeReviewInputBoundary {
    MakeReviewOutputBoundary presenter;

    public ReviewInteractor(MakeReviewOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * rate an Order (connected by orderID) by setting a Review, overwrite that data in MongoDB
     */
    public String saveReview(Review review) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        ReviewDataGateway gateway = new ReviewDataProcessorMongo(fetcher);

        return gateway.save(review);
    }

    @Override
    public MakeReviewResponseModel makeReview(MakeReviewRequestModel requestModel) {
        try {
            Review rev = new Review(new ObjectId(),
                    requestModel.getCurOrder(),
                    requestModel.getRating(),
                    requestModel.getComment(),
                    requestModel.getSubjectLine(),
                    requestModel.getPicPathList(),
                    requestModel.getLastEditTime());

            // save the Review to database
            String result = this.saveReview(rev);

            // generate response
            MakeReviewResponseModel response = new MakeReviewResponseModel(result);

            // call presenter to modify UI based on response model
            return this.presenter.prepareSuccessView(response);

        } catch (Exception e) {
            return this.presenter.prepareFailView(e.getMessage());
        }
    }

}