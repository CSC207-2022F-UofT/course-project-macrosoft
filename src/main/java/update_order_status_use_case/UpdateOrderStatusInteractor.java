package update_order_status_use_case;

// Application Business Rules Layer

import database.MongoCollectionFetcher;
import database.OrderDataGateway;
import database.OrderDataProcessorMongo;
import entities.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.text.DateFormat;

public class UpdateOrderStatusInteractor implements UpdateOrderStatusInputBoundary {

    final UpdateOrderStatusPresenter orderPresenter;


    public UpdateOrderStatusInteractor(UpdateOrderStatusPresenter orderPresenter) {
        this.orderPresenter = orderPresenter;
    }

    /**
     *
     * @param requestModel
     * @return
     */

    @Override
    public void updateOrderStatus(UpdateOrderStatusRequestModel requestModel) {
        try {
            MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
            OrderDataGateway orderDataGateway = new OrderDataProcessorMongo(fetcher);

            orderDataGateway.updateStatus(requestModel.getObjectId(), requestModel.getNewStatus());

            orderPresenter.prepareSuccessView();
        } catch (Exception e) {
            orderPresenter.prepareFailView("Failed");
        }
    }
}
