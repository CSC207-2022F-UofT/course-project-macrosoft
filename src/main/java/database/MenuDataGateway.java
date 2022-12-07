package database;
import entities.*;
import org.bson.types.ObjectId;

/**
 * Gateway for the Menu entity to Database.
 */
public interface MenuDataGateway {

    /**
     * Gets menu id by restaurant id
     *
     * @param restaurantId the restaurant id
     * @return the menu id of the restaurant
     */
    ObjectId newMenu(ObjectId restaurantId);

    /**
     * Sets the menu of a restaurant
     *
     * @param id      the restaurant id
     * @param newMenu the new menu
     */
    void setMenu(ObjectId id, Menu newMenu);

    /**
     * Gets menu by restaurant id
     *
     * @param RestId the restaurant id
     * @return the menu with the given restaurant id
     */
    Menu getMenu(ObjectId RestId);
}
