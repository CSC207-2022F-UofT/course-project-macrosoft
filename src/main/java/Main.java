import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Main {
    public static void main(String[] args) {

        ConnectionManager cm = new ConnectionManager();

        Document newRestaurantDoc = new Document("name", "testing_res");
        InsertOneResult result = cm.getCollection("Restaurants").insertOne(newRestaurantDoc);

    }

}
