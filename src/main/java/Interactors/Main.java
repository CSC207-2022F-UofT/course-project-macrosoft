package Interactors;

import Entities.*;
import DataModels.*;
import org.bson.types.ObjectId;

public class Main {

    public static void main(String[] args) {
        UserGetOrderInteractor userGetOrderInteractor = new UserGetOrderInteractor();

        userGetOrderInteractor.getOrders(new UserGetOrderRequestModel(new ObjectId("63335e7abb6cd6599ed6f64b"))).getOrders().forEach(item -> System.out.println(item.getOrderStatus()));
    }
}
