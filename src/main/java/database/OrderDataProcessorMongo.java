package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import entities.Food;
import entities.Order;
import entities.OrderItem;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for all interactions with the MongoDB database
 * related to orders.
 */
public class OrderDataProcessorMongo implements OrderDataGateway {
    MongoCollectionFetcher mongoCollectionFetcher;

    /**
     * Constructor for OrderDataProcessorMongo
     *
     * @param fetcher the fetcher for the collection
     */
    public OrderDataProcessorMongo(MongoCollectionFetcher fetcher) {
        this.mongoCollectionFetcher = fetcher;
    }

    /**
     * Saves an order to the database
     *
     * @param order the order to save
     */
    @Override
    public void save(Order order) {
        Document orderDoc = new Document("orderId", order.getOrderID())
                .append("restaurantID", order.getRestaurantID())
                .append("userID", order.getUserID())
                .append("items", order.getItems())
                .append("orderStatus", order.getOrderStatus())
                .append("orderDate", order.getOrderDate());
        this.mongoCollectionFetcher.getCollection("Orders").insertOne(orderDoc);
    }

    /**
     * Deletes an order from the database
     *
     * @param orderId the order id
     */
    @Override
    public void deleteByOrderId(ObjectId orderId) {
        MongoCollection orderCollection = mongoCollectionFetcher.getCollection("Orders");
        Bson filter = Filters.eq("orderID", orderId);
        orderCollection.deleteOne(filter);
    }

    /**
     * Creates a new order
     *
     * @param order the order to create
     * @return the id of the new order
     */
    @Override
    public ObjectId create(Order order) {
        Document newOrder = convertOrderToDocument(order);

        InsertOneResult result = this.mongoCollectionFetcher.getCollection("Orders").insertOne(newOrder);

        return result.getInsertedId().asObjectId().getValue();
    }

    /**
     * Finds all orders
     *
     * @return a list of all orders
     */
    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        mongoCollectionFetcher.getCollection("Orders")
                .find()
                .map(doc -> convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        return orders;
    }

    /**
     * Finds all orders by user id
     *
     * @param userId the user id
     * @return a list of all orders by user id
     */
    @Override
    public List<Order> findAllByUser(ObjectId userId) {
        Bson queryFilter = Filters.eq("userID", userId);

        List<Order> orders = new ArrayList<>();

        mongoCollectionFetcher.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        return orders;
    }

    /**
     * Finds all orders by restaurant id
     *
     * @param restaurantId the restaurant id
     * @return a list of all orders by restaurant id
     */
    @Override
    public List<Order> findAllByRestaurant(ObjectId restaurantId) {
        Bson queryFilter = Filters.eq("restaurantID", restaurantId);

        List<Order> orders = new ArrayList<>();

        mongoCollectionFetcher.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        return orders;
    }

    /**
     * Finds an order by id
     *
     * @param id the id of the order
     * @return the order
     */
    @Override
    public Order findById(ObjectId id) {
        Bson queryFilter = Filters.eq("_id", id);

        List<Order> orders = new ArrayList<>();

        mongoCollectionFetcher.getCollection("Orders")
                .find(queryFilter)
                .map(doc -> convertDocumentToOrder((Document) doc))
                .forEach(order -> orders.add((Order) order));

        if (orders.size() > 0)
            return orders.get(0);
        else
            return null;
    }

    /**
     * Updates an order status
     *
     * @param orderId   the order id
     * @param newStatus the new status of the order
     */
    @Override
    public void updateStatus(ObjectId orderId, String newStatus) {
        Bson queryFilter = Filters.eq("_id", orderId);
        Bson update = Updates.set("orderStatus", newStatus);

        mongoCollectionFetcher.getCollection("Orders").updateOne(queryFilter, update);
    }

    /**
     * Converts a document to an order
     *
     * @param document the document to convert
     * @return the order
     */
    public Order convertDocumentToOrder(Document document) {
        FoodDataGateway foodDataGateway = new FoodDataMongo(MongoCollectionFetcher.getFetcher());

        List<OrderItem> items = document.getList("items", Document.class)
                .stream()
                .map(doc ->
                        new OrderItem(
                                doc.getObjectId("foodItemID"),
                                convertDocToFood(doc.get("food", Document.class)),
                                doc.getInteger("numberOfItem")))
                .collect(Collectors.toList());


        return new Order(document.getObjectId("_id"),  // ObjectId _id is auto-generated by DB for this order
                document.getDate("orderDate"),
                document.getObjectId("restaurantID"),
                document.getObjectId("userID"),
                items,
                document.getString("orderStatus"));
    }

    /**
     * Converts an order to a document
     *
     * @param order the order to convert
     * @return the document
     */
    public Document convertOrderToDocument(Order order) {
        List<Document> items = order.getItems()
                .stream()
                .map(food -> new Document("numberOfItem", food.getNumberOfItem()).
                        append("food", convertFoodToDoc(food.getFood())).
                        append("foodItemID", food.getFoodItemID()))
                .collect(Collectors.toList());


        return new Document("restaurantID", order.getRestaurantID())
                .append("userID", order.getUserID())
                .append("items", items)
                .append("orderStatus", order.getOrderStatus())
                .append("orderDate", order.getOrderDate());
    }

    /**
     * Converts a food to a document
     *
     * @param curFood the food to convert
     * @return the document
     */
    public Document convertFoodToDoc(Food curFood) {
        return new Document("name", curFood.getName())
                .append("description", curFood.getDescription())
                .append("category", curFood.getCategory())
                .append("price", curFood.getPrice());
    }

    /**
     * Converts a document to a food
     *
     * @param doc the document to convert
     * @return the food
     */
    public Food convertDocToFood(Document doc) {
        return new Food(doc.getString("name"),
                doc.getString("description"),
                doc.getString("category"),
                doc.getDouble("price").floatValue(),
                doc.getObjectId("_id"));
    }
}
