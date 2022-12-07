package user_make_review_use_case;

public class MakeReviewResponseFormatter implements MakeReviewPresenter {
    @Override
    public MakeReviewResponseModel prepareSuccessView(MakeReviewResponseModel response) {
        ReviewUI ui = new ReviewUI(response);
        ui.setVisible(true);
        return null;
    }

    @Override
    public MakeReviewResponseModel prepareFailView(String error) {
        return null;
    }
}
