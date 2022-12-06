package register_restaurant_use_case;

import register_user_use_case.RegisterUserScreenInterface;

public interface RegisterRestaurantPresenter {
    void registerFailed(String message);
    void registerSuccessful(String message);
    void setScreen(RegisterRestaurantScreenInterface screen);
}
