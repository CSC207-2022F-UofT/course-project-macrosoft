package LoginUseCase;

public interface UserLoginPresenter {
    public UserLoginResponseModel loginSuccess(UserLoginResponseModel response);
    public UserLoginResponseModel loginFailed(UserLoginResponseModel response);
    public UserLoginResponseModel notVerified(UserLoginResponseModel response);
}
