package MenuEditingUseCase.first_try;

import Entities.Menu;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class AddFoodInteractor {

    /**
     *
     * @param curMenu
     * @param name
     * @param description
     * @param category
     * @param price
     */
    public static void add(Menu curMenu, String name, String description, String category, float price){

        DBConnection connectionManager = new MongoConnection();

        ObjectId menuId = curMenu.getMenuId();
        Document newFoodDoc = new Document("_id", new ObjectId());
        newFoodDoc.append("name", name).append("description",description).append("category", category).append("price", price);

        Bson filter = Filters.eq("_id", menuId);
        Bson update = Updates.push("Food", newFoodDoc);

        connectionManager.getCollection("Menus").updateOne(filter, update);

    }
}
