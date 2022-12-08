package test_update_order_status_use_case;

import org.bson.types.ObjectId;
import update_order_status_use_case.*;

public class UpdateOrderStatusScreenTestTemp {

    public static void main(String[] args) {
        ObjectId orderId = new ObjectId("63335f66bb6cd6599ed6f64d");
        UpdateOrderStatusOutputBoundary presenter = new UpdateOrderStatusPresenter(null);
        UpdateOrderStatusInputBoundary interactor = new UpdateOrderStatusInteractor(presenter);
        UpdateOrderStatusController controller = new UpdateOrderStatusController(interactor, orderId);

            UpdateOrderStatusScreenInterface screen = new UpdateOrderStatusScreen(controller);

            presenter.setScreen(screen);

            screen.getFrame().setVisible(true);
        }
}