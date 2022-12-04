package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import entities.Restaurant;
import entities.User;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDataMongo implements RestaurantDataGateway{
    MongoCollectionFetcher mongoCollectionFetcher;
    public RestaurantDataMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }
    @Override
    public String save(Restaurant restaurant) {
        this.mongoCollectionFetcher.getCollection("Restaurants").insertOne(convertRestaurantToDocument(restaurant));
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> lst = new ArrayList<>();
        this.mongoCollectionFetcher.getCollection("Restaurants")
                .find()  // finds all documents in an iterator
                .forEach(doc -> lst.add(convertDocumentToRestaurant((Document) doc)));
        return lst;
    }

    @Override
    public Restaurant findById(ObjectId id) {
        MongoCollection restaurantCollection = this.mongoCollectionFetcher.getCollection("Restaurants");

        // filter by Id
        Bson queryFilter = Filters.eq("_id", id);

        Document doc = (Document) restaurantCollection.find(queryFilter).first();

        if (doc != null) {return convertDocumentToRestaurant(doc);}
        else {return null;}
    }

    @Override
    public Restaurant findByRestaurantNamePassword(String restaurantName, String password) {
        MongoCollection restaurantCollection = this.mongoCollectionFetcher.getCollection("Restaurants");
        // filter by Id
        Bson queryFilter = Filters.eq("name", restaurantName);

        Document doc = (Document) restaurantCollection.find(queryFilter).first();

        if (doc != null) {return convertDocumentToRestaurant(doc);}
        else {return null;}
    }

    @Override
    public void updateVerifiedStatus(ObjectId restaurantId, Boolean newStatus) {
        MongoCollection restaurantCollection = this.mongoCollectionFetcher.getCollection("Restaurants");

        Bson queryFilter = Filters.eq("_id", restaurantId);
        Bson update = Updates.set("verified", newStatus);
        restaurantCollection.updateOne(queryFilter, update);
    }

    @Override
    public void UpdateRestaurantInfo(ObjectId restaurantID, String newName, String newEmail, String newLocation, String newPhone) {
        MongoCollection restaurantCollection = this.mongoCollectionFetcher.getCollection("Restaurants");

        List<Bson> updates = new ArrayList<>();

        if (newName != null) updates.add(Updates.set("name", newName));
        if (newEmail != null) updates.add(Updates.set("email", newEmail));
        if (newLocation != null) updates.add(Updates.set("location", newLocation));
        if (newPhone != null) updates.add(Updates.set("phone", newPhone));

        if (updates.size() == 0) return;

        Bson queryFilter = Filters.eq("_id", restaurantID);
        Bson update = Updates.combine(updates);

        restaurantCollection.updateOne(queryFilter, update);
    }

    public Restaurant convertDocumentToRestaurant(Document document) {
        return new Restaurant(document.getObjectId("_id"),
                document.getString("name"),
                document.getString("email"),
                document.getString("location"),
                document.getString("phone"),
                document.getBoolean("verified")
        );
    }

    public Document convertRestaurantToDocument(Restaurant restaurant) {
        return new Document("_id", restaurant.getRestaurantID())
                .append("name", restaurant.getName())
                .append("email", restaurant.getEmail())
                .append("location", restaurant.getLocation())
                .append("phone", restaurant.getPhone())
                .append("verified", restaurant.isVerified());
    }
}
