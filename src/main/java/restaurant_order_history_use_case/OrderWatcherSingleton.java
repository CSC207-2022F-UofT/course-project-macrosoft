package restaurant_order_history_use_case;

public class OrderWatcherSingleton {
    private static OrderWatcherSingleton orderWatcherSingletonInstance;

    private Thread orderWatcher;

    public OrderWatcherSingleton(Thread orderWatcher) {
        this.orderWatcher = orderWatcher;
    }

    public static OrderWatcherSingleton getOrderWatcherSingletonInstance() {
        return orderWatcherSingletonInstance;
    }

    public static void setOrderWatcherSingletonInstance(OrderWatcherSingleton orderWatcherSingletonInstance) {
        OrderWatcherSingleton.orderWatcherSingletonInstance = orderWatcherSingletonInstance;
    }

    public Thread getOrderWatcher() {
        return orderWatcher;
    }

    public void setOrderWatcher(Thread orderWatcher) {
        this.orderWatcher = orderWatcher;
    }
}
