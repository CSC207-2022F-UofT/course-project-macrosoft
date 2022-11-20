package MenuEditingUseCase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import Entities.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import LoginUseCase.LoginRestaurantInteractor;
import org.bson.types.ObjectId;

import Interactors.*;

import java.util.ArrayList;

public class GetMenuInteractor {

    /**
     *
     * @param restId
     * @return
     */
    public static Menu getMenu(ObjectId restId) {

        DBConnection connectionManager = new MongoConnection();
        Bson queryFilter = Filters.and(
                Filters.eq("restaurantId", restId));

        MongoIterable<Document> menus = connectionManager.getCollection("Menus").find(queryFilter);

        if(menus.first() != null){
            Document menuDoc = menus.first();
            return MenuDataConverter.convertDocToMenu(menuDoc);
        }
        else{
            Document newMenuDoc = new Document("restaurantId", restId);
            newMenuDoc.append("Food", new ArrayList<>());
            InsertOneResult result = connectionManager.getCollection("Menus").insertOne(newMenuDoc);

            return MenuDataConverter.convertDocToMenu(newMenuDoc);
        }
    }
}
