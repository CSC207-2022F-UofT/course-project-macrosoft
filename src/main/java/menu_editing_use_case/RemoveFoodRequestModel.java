package menu_editing_use_case;
import entities.*;
import org.bson.types.ObjectId;

// Application Business Rules Layer

/**
 * This class is the request model for the remove food use case.
 */
public class RemoveFoodRequestModel {

    ObjectId resId;

    private Menu curMenu;

    final private ObjectId foodToRemove;

    /**
     * Constructor for RemoveFoodRequestModel
     *
     * @param resId         the restaurant id
     * @param curMenu       the current menu
     * @param foodToRemove  the food to remove
     */
    public RemoveFoodRequestModel(ObjectId resId, Menu curMenu, ObjectId foodToRemove) {
        this.resId = resId;
        this.curMenu = curMenu;
        this.foodToRemove = foodToRemove;
    }

    /**
     * Gets the current menu
     * @return the current menu
     */
    public Menu getCurMenu() {
        return curMenu;
    }

    /**
     * Sets the current menu
     * @param curMenu the current menu
     */
    public void setCurMenu(Menu curMenu) {
        this.curMenu = curMenu;
    }

    /**
     * Gets the food id to remove
     * @return the food id
     */
    public ObjectId getFoodToRemove() {
        return foodToRemove;
    }

    /**
     * Gets the restaurant id
     * @return the restaurant id
     */
    public ObjectId getResId() {
        return resId;
    }
}
