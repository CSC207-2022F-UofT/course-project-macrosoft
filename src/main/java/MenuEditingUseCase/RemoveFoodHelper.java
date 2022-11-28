package MenuEditingUseCase;

import Entities.Food;
import Entities.Menu;
import Interactors.DBConnection;
import Interactors.MongoConnection;
import MenuEditingUseCase.first_try.FoodDataConverter;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class RemoveFoodHelper {

    public static Menu remove(Menu curMenu, Food delFood){
        curMenu.removeFoodItem(delFood);
        return curMenu;
    }
}
