package Interactors;

import DataModels.*;

public class GetOrderFacade {
    public UserGetOrderResponseModel getOrdersByUserId(UserGetOrderRequestModel requestModel) {
        UserGetOrderInteractor userGetOrderInteractor = new UserGetOrderInteractor();
        return userGetOrderInteractor.getOrders(requestModel);
    }

    public UserGetOrderResponseModel getOrdersByRestaurantId(UserGetOrderRequestModel requestModel) {
        UserGetOrderInteractor userGetOrderInteractor = new UserGetOrderInteractor();
        return userGetOrderInteractor.getOrders(requestModel);
    }

    public UserGetOrderResponseModel getOrdersByOrderId(UserGetOrderRequestModel requestModel) {
        UserGetOrderInteractor userGetOrderInteractor = new UserGetOrderInteractor();
        return userGetOrderInteractor.getOrders(requestModel);
    }
}
