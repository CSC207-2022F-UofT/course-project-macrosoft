package user_make_review_use_case;

import database.MongoCollectionFetcher;
import database.ReviewDataGateway;
import database.ReviewDataProcessorMongo;
import datamodels.MakeReviewRequestModel;
import datamodels.MakeReviewResponseModel;


public class MakeReviewController {
    public MakeReviewResponseModel makeReview(MakeReviewRequestModel request) {
        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        ReviewDataGateway gateway = new ReviewDataProcessorMongo(fetcher);

        MakeReviewPresenter presenter = new MakeReviewResponseFormatter();
        MakeReviewInputBoundary i = new ReviewInteractor(gateway, presenter);

        MakeReviewResponseModel response = i.makeReview(request);

        return response;
    }
}
