package MenuEditingUseCase;

import Entities.Menu;
import Entities.Restaurant;

public interface RemoveFoodInputBoundary {

    MenuEditingResponseModel create(RemoveFoodRequestModel requestModel);

    Menu getMenu(Restaurant curRes);
}
