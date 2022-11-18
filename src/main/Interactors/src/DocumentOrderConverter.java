import org.bson.Document;

import java.util.*;
import java.util.stream.Collectors;

public class DocumentOrderConverter {
    public static Order convertDocumentToOrder(Document document) {
        List<OrderItem> items = document.getList("items", Document.class)
                .stream()
                .map(doc ->
                        new OrderItem(
                                doc.getObjectId("foodItemID"),
                                null,
                                doc.getInteger("numberOfItem")))
                .collect(Collectors.toList());

        return new Order(document.getObjectId("_id"),
                document.getDate("orderDate"),
                document.getObjectId("restaurantID"),
                document.getObjectId("userID"),
                items,
                document.getString("orderStatus"));
    }

    public static Document convertOrderToDocument(Order order) {
        List<Document> items = order.getItems().stream()
                .filter(c -> c instanceof OrderItem)
                .map(c -> (OrderItem) c)
                .map(c -> new Document("foodItemID", c.getFoodItemID()).append("numberOfItem", c.getNumberOfItem()))
                .collect(Collectors.toList());

        Document doc = new Document("orderDate", order.getOrderDate())
                .append("restaurantID", order.getRestaurantID())
                .append("userID", order.getUserID())
                .append("items", items)
                .append("orderStatus", order.getOrderStatus());

        return doc;
    }
}
