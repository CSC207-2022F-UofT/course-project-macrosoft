package update_order_status_use_case;

import org.bson.types.ObjectId;

public class NewRequestModel {

    private ObjectId currentResId;
    public NewRequestModel(ObjectId currentResId) {
        this.currentResId = currentResId;
    }

    public ObjectId getCurrentResId() {
        return currentResId;
    }

    public void setCurRes(ObjectId currentResId) {
        this.currentResId = currentResId;
    }
}
