package menu_editing_use_case;

// Application Business Rules Layer

import entities.Menu;
import entities.Restaurant;

public interface RemoveFoodInputBoundary {

    MenuEditingResponseModel create(RemoveFoodRequestModel requestModel);

    Menu getMenu();

    Restaurant getCurRes();
}
