package menu_editing_use_case;
import entities.*;
import org.bson.types.ObjectId;

// Application Business Rules Layer

public class RemoveFoodRequestModel {

    ObjectId resId;

    private Menu curMenu;

    final private ObjectId foodToRemove;

    public RemoveFoodRequestModel(ObjectId resId, Menu curMenu, ObjectId foodToRemove) {
        this.resId = resId;
        this.curMenu = curMenu;
        this.foodToRemove = foodToRemove;
    }
    public Menu getCurMenu() {
        return curMenu;
    }

    public void setCurMenu(Menu curMenu) {
        this.curMenu = curMenu;
    }

    public ObjectId getFoodToRemove() {
        return foodToRemove;
    }

    public ObjectId getResId() {
        return resId;
    }

    public void setResId(ObjectId resId) {
        this.resId = resId;
    }

}
