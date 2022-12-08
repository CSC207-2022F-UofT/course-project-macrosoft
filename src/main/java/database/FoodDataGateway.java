package database;

import entities.Food;
import org.bson.types.ObjectId;

/**
 * Gateway for the Food entity to Database.
 */
public interface FoodDataGateway {
    /**
     * Gets food by food id and restaurant id
     *
     * @param foodId the food id
     * @param resId  the restaurant id
     * @return the food with the given food id and restaurant id
     */
    Food getFood(ObjectId foodId, ObjectId resId);
}
