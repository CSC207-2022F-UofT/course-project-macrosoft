package update_order_status_use_case;

import update_order_status_use_case.NewResponseModel;

public interface NewPanelInterface {

    void updateOrder();

    void setOrder(NewResponseModel responseModel);
}
