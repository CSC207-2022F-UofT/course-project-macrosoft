package TestDatabaseAccessor;

import DatabaseAccess.ConnectionManager;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDatabaseConnection {

    @Test
    public void databaseConnection(){
        ConnectionManager cm = new ConnectionManager();

        Document newRestaurantDoc = new Document("name", "testing_res");
        InsertOneResult result = cm.getCollection("Restaurants").insertOne(newRestaurantDoc);

        Bson queryFilter = Filters.eq("name", "testing_res");
        Document orderDocument = (Document) cm.getCollection("Restaurants")
                .find(queryFilter)
                .first();

        String access = orderDocument.get("name").toString();
        Assertions.assertEquals("testing_res", access);

        cm.getCollection("Orders").deleteOne(queryFilter);


    }
}
