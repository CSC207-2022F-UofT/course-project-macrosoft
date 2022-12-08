package menu_editing_use_case;

// Application Business Rules Layer

import entities.Menu;
import org.bson.types.ObjectId;

public interface RemoveFoodInputBoundary {

    void create(RemoveFoodRequestModel requestModel);

    Menu getMenu();

    ObjectId getResId();

}
