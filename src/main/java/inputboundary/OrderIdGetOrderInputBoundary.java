package inputboundary;

import datamodels.IdGetOrderRequestModel;
import datamodels.IdGetOrderResponseModel;

public interface OrderIdGetOrderInputBoundary {
    public IdGetOrderResponseModel getOrder(IdGetOrderRequestModel requestModel);
}
