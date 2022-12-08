package change_restaurant_info_use_case;

/**
 * this class is the presenter of the change restaurant information use case
 * It has one implementation which is the change restaurant information processor
 */


public interface ChangeRestaurantInfoPresenter {
    /**
     * success
     * @param message success message
     */
    void changeRestaurantInfoSuccess(String message);
    void changeRestaurantInfoFailed(String message);
    void setScreen(ChangeRestaurantInfoScreenInterface screen);
}
