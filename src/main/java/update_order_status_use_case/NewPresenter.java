package update_order_status_use_case;

import update_order_status_use_case.NewPanelInterface;
import update_order_status_use_case.NewResponseModel;

public interface NewPresenter {

    void orderFound(NewResponseModel newResponseModel);
    void orderNotFound();

    NewResponseModel prepareSuccessView(NewResponseModel responsModel);

    void setOrderPanel(NewPanelInterface newPanelInterface);
}
