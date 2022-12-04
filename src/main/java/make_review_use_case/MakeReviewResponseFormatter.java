package make_review_use_case;

import datamodels.MakeReviewResponseModel;

public class MakeReviewResponseFormatter implements MakeReviewPresenter {
    @Override
    public MakeReviewResponseModel prepareSuccessView(MakeReviewResponseModel response) {
        return null;
    }

    @Override
    public MakeReviewResponseModel prepareFailView(String error) {
        return null;
    }
}
