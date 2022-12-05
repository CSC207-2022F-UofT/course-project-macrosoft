package update_order_status_use_case;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;

public class NewController {
    private final NewInputBoundary newInteractor;
    ObjectId currentResId;

    public NewController(NewInputBoundary newInteractor, ObjectId currentResId) {
        this.newInteractor = newInteractor;
        this.currentResId = currentResId;
    }

    public void getOrders() {
        if(currentResId == null){
            return;
        }

        NewRequestModel requestModel = new NewRequestModel(this.getCurrentResId());

        newInteractor.displayOrders(requestModel);
    }

    public HashMap<String, List> getOrderDic() {
        return this.newInteractor.getOrderDic(this.currentResId);
    }

    public ObjectId getCurrentResId() {
        return currentResId;
    }

    public NewResponseModel getResponse(){
        return newInteractor.getResponse(currentResId);
    }
}
