package make_review_use_case;

public interface MakeReviewPresenter {

    MakeReviewResponseModel prepareSuccessView(MakeReviewResponseModel responseModel);

    MakeReviewResponseModel prepareFailView(String str);
}
