package restaurant_register_use_case;
/*
presenter of the restaurant register use case
 */
public interface RegisterRestaurantPresenter {
    void registerFailed(String message);
    void registerSuccessful(String message);
    void setScreen(RegisterRestaurantScreenInterface screen);
}
