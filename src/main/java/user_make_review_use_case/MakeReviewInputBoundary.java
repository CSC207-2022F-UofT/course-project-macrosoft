package user_make_review_use_case;

import datamodels.MakeReviewRequestModel;
import datamodels.MakeReviewResponseModel;

public interface MakeReviewInputBoundary {
    MakeReviewResponseModel makeReview(MakeReviewRequestModel requestModel);
}
