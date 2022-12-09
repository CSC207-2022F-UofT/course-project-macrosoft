package restaurant_order_history_use_case;

/**
 * This is a a singleton class that watches for new orders.
 */
public class OrderWatcherSingleton {
    private static OrderWatcherSingleton orderWatcherSingletonInstance;

    private final Thread orderWatcher;

    /**
     * Constructor for OrderWatcherSingleton
     *
     * @param orderWatcher the order watcher
     */
    public OrderWatcherSingleton(Thread orderWatcher) {
        this.orderWatcher = orderWatcher;
    }

    /**
     * Gets the order watcher singleton instance.
     *
     * @return the order watcher singleton instance
     */
    public static OrderWatcherSingleton getOrderWatcherSingletonInstance() {
        return orderWatcherSingletonInstance;
    }

    /**
     * Sets the order watcher singleton instance.
     *
     * @param orderWatcherSingletonInstance the order watcher singleton instance
     */
    public static void setOrderWatcherSingletonInstance(OrderWatcherSingleton orderWatcherSingletonInstance) {
        OrderWatcherSingleton.orderWatcherSingletonInstance = orderWatcherSingletonInstance;
    }

    /**
     * Gets the order watcher.
     *
     * @return the order watcher
     */
    public Thread getOrderWatcher() {
        return orderWatcher;
    }
}
