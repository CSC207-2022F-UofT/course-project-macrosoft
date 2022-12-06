package user_make_review_use_case;

import datamodels.MakeReviewResponseModel;
import user_make_review_use_case.screens.ReviewUI;

public class MakeReviewResponseFormatter implements MakeReviewPresenter {
    @Override
    public MakeReviewResponseModel prepareSuccessView(MakeReviewResponseModel response) {
        ReviewUI ui = new ReviewUI(response);
        return null;
    }

    @Override
    public MakeReviewResponseModel prepareFailView(String error) {
        return null;
    }
}
