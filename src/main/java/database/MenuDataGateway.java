package database;
import entities.*;

public interface MenuDataGateway {

    void setMenu(Restaurant curRes, Menu newMenu);

    Menu getMenu(Restaurant curRes);
}
