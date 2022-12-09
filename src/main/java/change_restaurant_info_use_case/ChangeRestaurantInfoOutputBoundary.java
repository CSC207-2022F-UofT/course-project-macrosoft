package change_restaurant_info_use_case;

/**
 * This interface is the presenter of the change restaurant information use case
 * It has one implementation which is the change restaurant information processor
 */
public interface ChangeRestaurantInfoOutputBoundary {
    /**
     * success
     *
     * @param message success message
     */
    void changeRestaurantInfoSuccess(String message);

    /**
     * failed
     *
     * @param message failed message
     */
    void changeRestaurantInfoFailed(String message);

    /**
     * set the change restaurant information screen interface
     *
     * @param screen the change restaurant information screen interface
     */
    void setScreen(ChangeRestaurantInfoScreenInterface screen);
}
