package Database;
import Entities.*;

public interface MenuDataGateway {

    void setMenu(Restaurant curRes, Menu newMenu);

    Menu getMenu(Restaurant curRes);
}
