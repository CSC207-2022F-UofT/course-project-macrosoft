package UpdateOrderStatusUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.types.ObjectId;

import org.bson.conversions.Bson;


public class UpdateOrderStatusInteractor {

    private static DBConnection connectionManager = new MongoConnection();
    // creating a DB connection object

    public void updateOrderStatus(ObjectId orderId, String orderStatus) {
        // taking two parameter orderId and orderStatus.
        // orderId is an ObjectId, used for tracking the specific order that we want to update the status of it.
        // orderStatus is a String, used for updating the order status of an order

        Bson idFilter = Filters.eq("_id", orderId);
        // filter out the specific Order with order id ("_id" in DB) orderID

        Bson updates = Updates.set("orderStatus", orderStatus);
        // set the order status ("orderStatus" in DB) of the order to orderStatus.

        connectionManager.getCollection("Orders")
                // get the order collection that are named "Orders" in our DB

                .updateOne(idFilter, updates);
        // using updateOne to update the order that filtered by idFilter and update its order status with updates.

    }
}
