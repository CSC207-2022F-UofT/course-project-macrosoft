package database;
import entities.*;
import org.bson.types.ObjectId;

public interface MenuDataGateway {

    ObjectId newMenu(ObjectId restaurantId);

    void setMenu(ObjectId id, Menu newMenu);

    Menu getMenu(ObjectId RestId);
}
