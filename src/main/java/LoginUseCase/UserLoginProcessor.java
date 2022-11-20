package LoginUseCase;

import LoginUseCase.UserLoginPresenter;
import LoginUseCase.UserLoginResponseModel;

public class UserLoginProcessor implements UserLoginPresenter {
    @Override
    public UserLoginResponseModel loginSuccess(UserLoginResponseModel response) {
        return response;
    }

    @Override
    public UserLoginResponseModel loginFailed(UserLoginResponseModel response) {
        return response;
    }

    @Override
    public UserLoginResponseModel notVerified(UserLoginResponseModel response) {
        return response;
    }
}
