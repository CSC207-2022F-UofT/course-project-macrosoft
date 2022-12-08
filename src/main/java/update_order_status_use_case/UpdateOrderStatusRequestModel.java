package update_order_status_use_case;

// Application Business Rule Layer

import org.bson.types.ObjectId;

public class UpdateOrderStatusRequestModel {

    private ObjectId objectId;
    private String newStatus;

    public UpdateOrderStatusRequestModel(ObjectId objectId, String newStatus) {
        this.objectId = objectId;
        this.newStatus = newStatus;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}
