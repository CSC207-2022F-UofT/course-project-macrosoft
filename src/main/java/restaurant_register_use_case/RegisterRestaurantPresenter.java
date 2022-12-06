package restaurant_register_use_case;

public interface RegisterRestaurantPresenter {
    void registerFailed(String message);
    void registerSuccessful(String message);
    void setScreen(RegisterRestaurantScreenInterface screen);
}
