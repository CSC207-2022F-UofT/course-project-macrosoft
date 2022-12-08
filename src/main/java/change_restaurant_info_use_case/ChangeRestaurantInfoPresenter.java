package change_restaurant_info_use_case;


public interface ChangeRestaurantInfoPresenter {
    void changeRestaurantInfoSuccess(String message);

    void changeRestaurantInfoFailed(String message);

    void setScreen(ChangeRestaurantInfoScreenInterface screen);
}
