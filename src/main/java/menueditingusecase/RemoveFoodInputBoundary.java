package menueditingusecase;

// Application Business Rules Layer

import entities.Menu;
import entities.Restaurant;

public interface RemoveFoodInputBoundary {

    MenuEditingResponseModel create(RemoveFoodRequestModel requestModel);

    Menu getMenu();

    Restaurant getCurRes();
}
