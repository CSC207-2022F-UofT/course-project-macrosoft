package MenuEditingUseCase;

// Application Business Rules Layer

import Entities.Menu;
import Entities.Restaurant;

public interface RemoveFoodInputBoundary {

    MenuEditingResponseModel create(RemoveFoodRequestModel requestModel);

    Menu getMenu();

    Restaurant getCurRes();
}
