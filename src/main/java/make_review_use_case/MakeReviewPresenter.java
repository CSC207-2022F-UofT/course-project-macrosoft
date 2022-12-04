package make_review_use_case;

import datamodels.MakeReviewResponseModel;

public interface MakeReviewPresenter {

    MakeReviewResponseModel prepareSuccessView(MakeReviewResponseModel responseModel);

    MakeReviewResponseModel prepareFailView(String str);
}
