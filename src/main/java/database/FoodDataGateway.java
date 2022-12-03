package database;

import entities.Food;
import org.bson.types.ObjectId;

public interface FoodDataGateway {
    Food getFood(ObjectId foodId, ObjectId resId);
}
