package restaurant_homepage_use_case;

import org.bson.types.ObjectId;
import restaurant_profile_use_case.*;

import javax.swing.*;

public class RestaurantHomepageController {
    ObjectId currentRestaurantId;

    public RestaurantHomepageController(ObjectId currentRestaurantId) {
        this.currentRestaurantId = currentRestaurantId;
    }

    public JPanel getRestaurantProfilePanel(ObjectId currentRestaurantId){
        RestaurantProfilePresenter presenter =  new RestaurantProfileProcessor(null);
        RestaurantProfileInputBoundary interactor = new RestaurantProfileIneractor(presenter);
        RestaurantProfileController controller = new RestaurantProfileController(interactor, currentRestaurantId);

        RestaurantProfilePanel panel = new RestaurantProfilePanel(controller);
        presenter.setRestaurantProfilePanel(panel);
        panel.updatePanelData();

        return (JPanel)panel;
    }

    public ObjectId getCurrentRestaurantId() {
        return currentRestaurantId;
    }
}
