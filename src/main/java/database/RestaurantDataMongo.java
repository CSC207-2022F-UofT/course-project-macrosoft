package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import entities.Restaurant;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to restaurants.
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class RestaurantDataMongo implements RestaurantDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;

    public RestaurantDataMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * Gets the id of a new restaurant
     *
     * @param name     the name of the new restaurant
     * @param email    the email of the new restaurant
     * @param location the location of the new restaurant
     * @param phone    the phone number of the new restaurant
     * @return the id of the new restaurant
     */
    @Override
    public ObjectId newRestaurant(String name, String email, String location, String phone) {
        Document newRestaurantDoc = new Document("name", name)
                .append("email", email)
                .append("location", location)
                .append("phone", phone)
                .append("menu", null)
                .append("verified", false);

        InsertOneResult result = this.mongoCollectionFetcher.getCollection("Restaurants").insertOne(newRestaurantDoc);

        return result.getInsertedId().asObjectId().getValue();
    }

    /**
     * Saves a restaurant to the database
     *
     * @param restaurant the restaurant to be saved
     */
    @Override
    public void save(Restaurant restaurant) {
        this.mongoCollectionFetcher.getCollection("Restaurants").insertOne(convertRestaurantToDocument(restaurant));
    }

    /**
     * Finds all restaurants in the database
     *
     * @return a list of all restaurants in the database
     */
    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> lst = new ArrayList<>();
        this.mongoCollectionFetcher.getCollection("Restaurants")
                .find()  // finds all documents in an iterator
                .forEach(doc -> lst.add(convertDocumentToRestaurant((Document) doc)));
        return lst;
    }

    /**
     * Finds a restaurant by its id
     *
     * @param id the id of the restaurant
     * @return the restaurant with the given id
     */
    @Override
    public Restaurant findById(ObjectId id) {
        MongoCollection restaurantCollection = this.mongoCollectionFetcher.getCollection("Restaurants");

        // filter by Id
        Bson queryFilter = Filters.eq("_id", id);

        Document doc = (Document) restaurantCollection.find(queryFilter).first();

        if (doc != null) {
            return convertDocumentToRestaurant(doc);
        } else {
            return null;
        }
    }

    /**
     * Finds a restaurant by its name
     *
     * @param restaurantName the name of the restaurant
     * @return a list of restaurants with the given name
     */
    @Override
    public List<Restaurant> findByRestaurantName(String restaurantName) {
        List<Restaurant> resultRestaurants = new ArrayList<>();

        MongoCollection restaurantCollection = this.mongoCollectionFetcher.getCollection("Restaurants");
        Bson queryFilter = Filters.regex("name", ".*" + restaurantName + ".*", "i");

        MongoIterable<Document> results = restaurantCollection.find(queryFilter);

        if (results != null) {
            for (Document resDoc : results) {
                resultRestaurants.add(this.convertDocumentToRestaurant(resDoc));
            }
        }

        return resultRestaurants;
    }

    /**
     * Updates the verified status of a restaurant
     *
     * @param restaurantId the id of the restaurant to be updated
     * @param newStatus    the new verified status of the restaurant
     */
    @Override
    public void updateVerifiedStatus(ObjectId restaurantId, Boolean newStatus) {
        MongoCollection restaurantCollection = this.mongoCollectionFetcher.getCollection("Restaurants");

        Bson queryFilter = Filters.eq("_id", restaurantId);
        Bson update = Updates.set("verified", newStatus);
        restaurantCollection.updateOne(queryFilter, update);
    }

    /**
     * Finds the restaurant name by the restaurant id.
     *
     * @param restId the restaurant id
     * @return String the restaurant name found by the id
     */
    @Override
    public String getRestaurantNameById(ObjectId restId) {
        Bson filter = Filters.eq("_id", restId);
        MongoIterable<Document> restaurants = mongoCollectionFetcher.getCollection("Restaurants").find(filter);

        if (restaurants.first() != null) {
            return restaurants.first().getString("name");
        }
        return null;
    }

    /**
     * Updates the information of a restaurant
     *
     * @param restaurantID the id of the restaurant to be updated
     * @param newName      the new name of the restaurant
     * @param newEmail     the new email of the restaurant
     * @param newLocation  the new location of the restaurant
     * @param newPhone     the new phone number of the restaurant
     */
    @Override
    public void updateRestaurantInfo(ObjectId restaurantID, String newName, String newEmail, String newLocation, String newPhone) {
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

    /**
     * Updates the menu of a restaurant based on the restaurant id and the menu id
     *
     * @param restaurantId the id of the restaurant to be updated
     * @param menuId       the id of the menu to be added to the restaurant
     */
    public void updateMenuId(ObjectId restaurantId, ObjectId menuId) {
        Bson queryFilter = Filters.eq("_id", restaurantId);
        Bson updates = Updates.set("menu", menuId);

        this.mongoCollectionFetcher.getCollection("Restaurants").updateOne(queryFilter, updates);
    }

    @Override
    public void removeResById(ObjectId id) {
        MongoCollection collection = mongoCollectionFetcher.getCollection("Restaurants");
        Bson queryFiler = Filters.eq("_id", id);
        collection.deleteOne(queryFiler);
    }

    /**
     * Converts a document object to a restaurant
     *
     * @param document the document to be converted
     * @return the restaurant representation of the document
     */
    public Restaurant convertDocumentToRestaurant(Document document) {
        return new Restaurant(document.getObjectId("_id"),
                document.getString("name"),
                document.getString("email"),
                document.getString("location"),
                document.getString("phone"),
                document.getBoolean("verified")
        );
    }

    /**
     * Converts a restaurant to a document object
     *
     * @param restaurant the restaurant to be converted
     * @return the document representation of the restaurant
     */
    public Document convertRestaurantToDocument(Restaurant restaurant) {
        return new Document("_id", restaurant.getRestaurantID())
                .append("name", restaurant.getName())
                .append("email", restaurant.getEmail())
                .append("location", restaurant.getLocation())
                .append("phone", restaurant.getPhone())
                .append("verified", restaurant.isVerified());
    }
}
