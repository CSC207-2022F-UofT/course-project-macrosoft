package restaurant_register_use_case;

/**
 * presenter of the restaurant register use case
 */
public interface RegisterRestaurantOutputBoundary {
    /**
     * Failed to register the restaurant.
     *
     * @param message the message
     */
    void registerFailed(String message);

    /**
     * Successfully registered the restaurant.
     *
     * @param message the message
     */
    void registerSuccessful(String message);

    /**
     * Sets the screen.
     *
     * @param screen the resister restaurant screen
     */
    void setScreen(RegisterRestaurantScreenInterface screen);
}
