package TestDatabaseAccessor;

import interactors.DBConnection;
import interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDatabaseConnection {

    @Test
    public void databaseConnection(){
        DBConnection dbConnection = new MongoConnection();

        Document newRestaurantDoc = new Document("name", "testing_res");
        InsertOneResult result = dbConnection.getCollection("Restaurants").insertOne(newRestaurantDoc);

        Bson queryFilter = Filters.eq("name", "testing_res");
        Document orderDocument = (Document) dbConnection.getCollection("Restaurants")
                .find(queryFilter)
                .first();

        String access = orderDocument.get("name").toString();
        Assertions.assertEquals("testing_res", access);

        dbConnection.getCollection("Orders").deleteOne(queryFilter);


    }
}
