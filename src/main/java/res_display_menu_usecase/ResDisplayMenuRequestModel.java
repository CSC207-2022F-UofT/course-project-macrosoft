package res_display_menu_usecase;
import org.bson.types.ObjectId;

public class ResDisplayMenuRequestModel {

    private ObjectId restId;

    public ResDisplayMenuRequestModel(ObjectId restId) {
        this.restId = restId;
    }

    public ObjectId getRestId() {
        return restId;
    }

    public void setRestId(ObjectId restId) {
        this.restId = restId;
    }
}
