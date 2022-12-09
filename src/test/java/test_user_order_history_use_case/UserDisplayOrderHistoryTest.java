package test_user_order_history_use_case;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user_order_history_use_case.OrderHistoryController;
import user_order_history_use_case.OrderHistoryInteractor;
import user_order_history_use_case.OrderHistoryPresenter;

public class UserDisplayOrderHistoryTest {

    @Test
    void test_get_current_userID() {
        OrderHistoryPresenter presenter = new OrderHistoryPresenter(null);
        OrderHistoryInteractor interactor = new OrderHistoryInteractor(presenter);
        OrderHistoryController controller = new OrderHistoryController(interactor, new ObjectId("638d4a9e466a656b5a298db9"));

        ObjectId userId = controller.getCurrentUserId();
        Assertions.assertEquals(userId.toString(), "638d4a9e466a656b5a298db9");
    }
}
