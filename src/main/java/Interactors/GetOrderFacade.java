package Interactors;

import DataModels.*;

public class GetOrderFacade {
    public UserGetOrderResponseModel getOrdersByUserId(UserGetOrderRequestModel requestModel) {
        UserGetOrderInteractor userGetOrderInteractor = new UserGetOrderInteractor();
        return userGetOrderInteractor.getOrders(requestModel);
    }

    public RestaurantGetOrderResponseModel getOrdersByRestaurantId(RestaurantGetOrderRequestModel requestModel) {
        RestaurantGetOrderInteractor restaurantGetOrderInteractor = new RestaurantGetOrderInteractor();
        return restaurantGetOrderInteractor.getOrders(requestModel);
    }

    public IdGetOrderResponseModel getOrdersByOrderId(IdGetOrderRequestModel requestModel) {
        OrderIdGetOrderInteractor orderIdGetOrderInteractor = new OrderIdGetOrderInteractor();
        return orderIdGetOrderInteractor.getOrders(requestModel);
    }
}
