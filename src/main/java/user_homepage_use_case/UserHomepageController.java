package user_homepage_use_case;

import user_order_history_use_case.*;
import org.bson.types.ObjectId;
import user_display_restaurants_use_case.*;
import user_profile_use_case.*;
import user_shopping_cart_use_case.*;

import javax.swing.*;

public class UserHomepageController {

    private ObjectId userId;

    public UserHomepageController(ObjectId userId) {
        this.userId = userId;
    }

    public JPanel getUserProfilePanel(ObjectId userId){
        UserProfilePresenter userProfilePresenter = new UserProfileProcessor(null);
        UserProfileInputBoundary userProfileInteractor = new UserProfileInteractor(userProfilePresenter);
        UserProfileController userProfileController = new UserProfileController(userProfileInteractor, userId);

        UserProfilePanelInterface userProfilePanel = new UserProfilePanel(userProfileController);


        userProfilePresenter.setUserProfilePanel(userProfilePanel);
        userProfilePanel.updatePanelData();

        return (JPanel)userProfilePanel;
    }

    public JPanel getUserOrderHistoryPanel(ObjectId userId){
        OrderHistoryPresenter orderHistoryPresenter = new OrderHistoryProcessor(null);
        OrderHistoryInputBoundary orderHistoryInteractor = new OrderHistoryInteractor(orderHistoryPresenter);
        OrderHistoryController orderHistoryController = new OrderHistoryController(orderHistoryInteractor, userId);

        OrderHistoryPanelInterface orderHistoryPanel = new OrderHistoryPanel(orderHistoryController);

        orderHistoryPresenter.setOrderHistoryPanel(orderHistoryPanel);
        orderHistoryPanel.updateOrder();

        return (JPanel) orderHistoryPanel;
    }

    public JPanel getUserDisplayRestaurantsPanel(ObjectId userId) {
        UserDisplayRestaurantPresenter userDisplayRestaurantPresenter = new UserDisplayRestaurantProcessor(null);
        UserDisplayRestaurantInputBoundary userDisplayRestaurantInteractor = new UserDisplayRestaurantInteractor(userDisplayRestaurantPresenter);
        UserDisplayRestaurantController userDisplayRestaurantController = new UserDisplayRestaurantController(userDisplayRestaurantInteractor);

        UserDisplayRestaurantPanelInterface screen = new UserDisplayRestaurantPanel(userDisplayRestaurantController);


        userDisplayRestaurantPresenter.setScreen(screen);

        screen.refreshData();

        return (JPanel) screen;
    }

    public JPanel getShoppingCartPanel() {
        ShoppingCartPresenter shoppingCartPresenter = new ShoppingCartProcessor(null);
        ShoppingCartInputBoundary shoppingCartInputBoundary = new ShoppingCartInteractor(shoppingCartPresenter);
        ShoppingCartController shoppingCartController = new ShoppingCartController(shoppingCartInputBoundary);

        ShoppingCartPanelInterface screen = new ShoppingCartPanel(shoppingCartController);


        shoppingCartPresenter.setScreen(screen);

        screen.refreshData();

        return (JPanel) screen;
    }

    public ObjectId getUserId() {
        return userId;
    }
}
