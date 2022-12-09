package user_make_review_use_case;

/**
 * presenter of the make review use case.
 * prepares the success and fail view
 */
public interface MakeReviewOutputBoundary {

    /**
     * react to the successfully saving the review,
     * create a new window (ReviewUI) to notify user that the task is successful
     *
     * @param responseModel response model
     */
    void prepareSuccessView(MakeReviewResponseModel responseModel);

    /**
     * prepare the response view when save review failed
     *
     * @param str error message
     */
    void prepareFailView(String str);
}
