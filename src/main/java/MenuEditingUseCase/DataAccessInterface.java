package MenuEditingUseCase;
import Entities.*;

public interface DataAccessInterface {

    Menu getMenu(Restaurant curRes);

    void setMenu(Restaurant curRes, Menu newMenu);
}
