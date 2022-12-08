package user_shopping_cart_use_case;

import database.*;
import entities.Food;
import entities.Order;
import entities.OrderItem;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is the interactor of checkout.
 */
public class CheckoutInteractor implements CheckoutInputBoundary {
    CheckoutPresenter presenter;

    /**
     * Constructor for CheckoutInteractor
     *
     * @param presenter the presenter
     */
    public CheckoutInteractor(CheckoutPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Checkout.
     *
     * @param requestModel the request model
     */
    public void checkout(CheckoutRequestModel requestModel) {
        if (requestModel.getUserId() == null) {
            presenter.checkoutFailed("User invalid");
            return;
        }

        if (requestModel.getRestaurantId() == null || requestModel.getCart().size() == 0) {
            presenter.checkoutFailed("Your shopping cart is empty");
            return;
        }

        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);
        FoodDataGateway foodDataGateway = new FoodDataMongo(fetcher);

        List<OrderItem> orderItems = new ArrayList<>();

        for (ObjectId foodId : requestModel.getCart().keySet()) {
            Food food = foodDataGateway.getFood(foodId, requestModel.getRestaurantId());
            OrderItem orderItem = new OrderItem(foodId, food, requestModel.getCart().get(foodId));
            orderItems.add(orderItem);
        }

        Order order = new Order(null, new Date(), requestModel.getRestaurantId(), requestModel.getUserId(), orderItems, "Order Received");

        ObjectId newOrderId = orderDataGateway.create(order);

        presenter.checkoutSuccess("Your order ID is: " + newOrderId);
    }
}
