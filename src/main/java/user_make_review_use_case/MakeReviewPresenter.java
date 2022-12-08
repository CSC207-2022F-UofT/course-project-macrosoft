package user_make_review_use_case;

public class MakeReviewPresenter implements MakeReviewOutputBoundary {
    /**
     * react to the successfully saving the review, create a new window (ReviewUI) to notify user that the task is successful
     * @param response
     * @return
     */
    @Override
    public MakeReviewResponseModel prepareSuccessView(MakeReviewResponseModel response) {
        ReviewUI ui = new ReviewUI(response);
        ui.setVisible(true);
        return null;
    }

    /**
     * prepare the response view when save review failed
     * @param error error message
     * @return return
     */
    @Override
    public MakeReviewResponseModel prepareFailView(String error) {
        return null;
    }
}
