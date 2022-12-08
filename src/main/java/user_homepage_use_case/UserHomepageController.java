package user_homepage_use_case;

import components.ScreenFactory;
import org.bson.types.ObjectId;

import javax.swing.*;

public class UserHomepageController {

    private ObjectId userId;

    public UserHomepageController(ObjectId userId) {
        this.userId = userId;
    }

    public JPanel getUserProfilePanel(ObjectId userId){
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createUserProfilePanel(userId);
    }

    public JPanel getUserOrderHistoryPanel(ObjectId userId){
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createUserOrderHistoryPanel(userId);
    }

    public JPanel getUserDisplayRestaurantsPanel(ObjectId userId) {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.createUserDisplayRestaurantsPanel(userId);
    }

    public JPanel getShoppingCartPanel() {
        ScreenFactory screenFactory = new ScreenFactory();
        return screenFactory.getShoppingCartPanel(userId);
    }

    public ObjectId getUserId() {
        return userId;
    }
}
