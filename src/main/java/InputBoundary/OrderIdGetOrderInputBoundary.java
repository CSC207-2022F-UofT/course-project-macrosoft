package InputBoundary;

import DataModels.IdGetOrderRequestModel;
import DataModels.IdGetOrderResponseModel;

public interface OrderIdGetOrderInputBoundary {
    public IdGetOrderResponseModel getOrder(IdGetOrderRequestModel requestModel);
}
