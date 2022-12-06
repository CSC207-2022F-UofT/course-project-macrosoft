package database;
import entities.*;
import org.bson.types.ObjectId;

public interface MenuDataGateway {

    ObjectId newMenu(ObjectId restaurantId);

    void setMenu(Restaurant curRes, Menu newMenu);

    Menu getMenu(Restaurant curRes);

    Menu getMenu(ObjectId RestId);
}
