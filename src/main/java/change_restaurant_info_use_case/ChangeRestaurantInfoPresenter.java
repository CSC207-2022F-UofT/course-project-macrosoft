package change_restaurant_info_use_case;

/**
 * this class is the presenter of the change restaurant information use case
 * It has one implementation which is the change restaurant information processor
 */


/**
 * This interface is for the change restaurant info presenter in change restaurant info use case
 */
public interface ChangeRestaurantInfoPresenter {


    /**
     * Show change the restaurant information succeeded screen
     *
     * @param message the success message to be shown
     */
    void changeRestaurantInfoSuccess(String message);

    /**
     * Show change the restaurant information failed screen
     *
     * @param message the message to be shown
     */
    void changeRestaurantInfoFailed(String message);


    /**
     * Set the screen to the screen given
     *
     * @param screen the change restaurant info screen
     */
    void setScreen(ChangeRestaurantInfoScreenInterface screen);
}
