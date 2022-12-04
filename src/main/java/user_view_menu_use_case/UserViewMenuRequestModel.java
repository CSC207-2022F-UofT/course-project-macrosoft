package user_view_menu_use_case;
import org.bson.types.ObjectId;

public class UserViewMenuRequestModel {

    private ObjectId resId;

    public ObjectId getResId() {
        return resId;
    }

    public void setResId(ObjectId resId) {
        this.resId = resId;
    }

    public UserViewMenuRequestModel(ObjectId resId) {
        this.resId = resId;
    }
}
