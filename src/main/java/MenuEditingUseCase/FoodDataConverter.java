package MenuEditingUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;

import Entities.*;
import org.bson.Document;
import org.bson.types.ObjectId;

public class FoodDataConverter {
    /**
     *
     * @param foodDoc
     * @return
     */
    public static Food convertDocToFood(Document foodDoc){
        if (foodDoc.isEmpty()){
            return null;
        }
        return new Food(foodDoc.getString("name"),
                foodDoc.getString("description"),
                foodDoc.getString("category"),
                foodDoc.getDouble("price").floatValue(),
                foodDoc.getObjectId("_id"));
    }

    /**
     *
     * @param curFood
     * @return
     */

    public static Document convertFoodToDoc(Food curFood){
        return new Document("_id", new ObjectId())
                .append("name", curFood.getName())
                .append("description", curFood.getDescription())
                .append("category", curFood.getCategory())
                .append("price", curFood.getPrice());
    }
}
