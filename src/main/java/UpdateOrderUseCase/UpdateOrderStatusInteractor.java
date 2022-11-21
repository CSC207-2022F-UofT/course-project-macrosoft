package UpdateOrderUseCase;

import Interactors.DBConnection;
import Interactors.MongoConnection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.types.ObjectId;

import org.bson.conversions.Bson;


public class UpdateOrderStatusInteractor {

    private static DBConnection connectionManager = new MongoConnection();

    public void updateOrderStatus(ObjectId orderId, String orderStatus) {

        Bson idFilter = Filters.eq("_id", orderId);
        Bson updates = Updates.set("orderStatus", orderStatus);

        connectionManager.getCollection("Orders")
                .updateOne(idFilter, updates);
    }
}
