package user_make_review_use_case;

public class MakeReviewPresenter implements MakeReviewOutputBoundary {
    /**
     * react to the successfully saving the review,
     * create a new window (ReviewUI) to notify user that the task is successful
     *
     * @param response response model
     */
    @Override
    public void prepareSuccessView(MakeReviewResponseModel response) {
        ReviewUI ui = new ReviewUI(response);
        ui.setVisible(true);
    }

    /**
     * prepare the response view when save review failed
     *
     * @param error error message
     */
    @Override
    public void prepareFailView(String error) {
    }
}
