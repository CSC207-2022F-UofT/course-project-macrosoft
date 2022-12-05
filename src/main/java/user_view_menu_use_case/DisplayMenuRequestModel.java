package user_view_menu_use_case;
import org.bson.types.ObjectId;

public class DisplayMenuRequestModel {

    private ObjectId restId;

    public DisplayMenuRequestModel(ObjectId restId) {
        this.restId = restId;
    }

    public ObjectId getRestId() {
        return restId;
    }

    public void setRestId(ObjectId restId) {
        this.restId = restId;
    }
}
