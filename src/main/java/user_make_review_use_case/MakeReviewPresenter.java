package user_make_review_use_case;

/**
 * presenter of the make review use case.
 * prepares the success and fail view
 */
public interface MakeReviewPresenter {

    MakeReviewResponseModel prepareSuccessView(MakeReviewResponseModel responseModel);

    MakeReviewResponseModel prepareFailView(String str);
}
