package components;

import change_password_use_case.*;
import change_restaurant_info_use_case.*;
import change_user_info_use_case.*;
import login_use_case.*;
import menu_editing_use_case.*;
import menu_editing_use_case.Screens.AddFoodScreen;
import menu_editing_use_case.Screens.FoodEditingScreen;
import org.bson.types.ObjectId;
import res_display_menu_usecase.*;
import restaurant_homepage_use_case.*;
import restaurant_order_history_use_case.*;
import restaurant_profile_use_case.*;
import restaurant_register_use_case.*;
import restaurant_verify_use_case.*;
import update_order_status_use_case.*;
import user_display_restaurants_use_case.*;
import user_homepage_use_case.*;
import user_make_review_use_case.*;
import user_order_history_use_case.*;
import user_profile_use_case.*;
import user_register_use_case.*;
import user_shopping_cart_use_case.*;
import user_verify_use_case.*;
import user_view_menu_use_case.*;
import welcome_use_case.WelcomeScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

// Responsibility: create screen

public class ScreenFactory {
    public void createWelcomeScreen() {
        WelcomeScreen screen = new WelcomeScreen();
    }

    public void createLoginSreen() {
        UserLoginPresenter userLoginPresenter = new UserLoginProcessor(null);
        UserLoginInputBoundary userLoginInteractor = new UserLoginInteractor(userLoginPresenter);
        RestaurantLoginInputBoundary restaurantLoginInteractor = new RestaurantLoginInteractor(userLoginPresenter);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor, restaurantLoginInteractor);
        UserLoginScreenInterface screen = new UserLoginScreen(userLoginController);
        userLoginPresenter.setLoginScreen(screen);
        screen.getFrame().setVisible(true);
    }

    public void createUserRegisterScreen() {
        RegisterUserPresenter registerUserPresenter = new RegisterUserProcessor(null);
        RegisterUserInputBoundary registerUserInputBoundary = new RegisterUserInteractor(registerUserPresenter);
        RegisterUserController registerUserController = new RegisterUserController(registerUserInputBoundary);
        RegisterUserScreenInterface screen = new RegisterUserScreen(registerUserController);
        registerUserPresenter.setScreen(screen);
        screen.getFrame().setVisible(true);
    }

    public void createRestaurantRegisterScreen() {
        RegisterRestaurantPresenter registerRestaurantPresenter = new RegisterRestaurantProcessor(null);
        RegisterRestaurantInputBoundary registerRestaurantInputBoundary = new RegisterRestaurantInteractor(registerRestaurantPresenter);
        RegisterRestaurantController registerRestaurantController = new RegisterRestaurantController(registerRestaurantInputBoundary);
        RegisterRestaurantScreenInterface screen = new RegisterRestaurantScreen(registerRestaurantController);
        registerRestaurantPresenter.setScreen(screen);
        screen.getFrame().setVisible(true);
    }

    public void createVerifyUserScreen(ObjectId userId) {
        VerifyUserPresenter verifyUserPresenter = new VerifyUserProcessor(null);
        VerifyUserFacade verifyUserFacade = new VerifyUserFacade(verifyUserPresenter);
        VerifyUserController verifyUserController = new VerifyUserController(verifyUserFacade, userId);
        VerifyUserScreenInterface verifyUserScreen = new VerifyUserScreen(verifyUserController);

        verifyUserPresenter.setVerifyUserScreen(verifyUserScreen);

        verifyUserScreen.getFrame().setVisible(true);
    }

    public void createVerifyRestaurantScreen(ObjectId restaurantId) {
        VerifyResPresenter verifyResPresenter = new VerifyResProcessor(null);
        VerifyResFacade verifyResFacade = new VerifyResFacade(verifyResPresenter);
        VerifyResController verifyResController = new VerifyResController(verifyResFacade, restaurantId);
        VerifyResScreenInterface verifyResScreen = new VerifyResScreen(verifyResController);

        verifyResPresenter.setVerifyResScreenInterface(verifyResScreen);

        verifyResScreen.getFrame().setVisible(true);
    }

    public void createUserHomepageScreen(ObjectId userId) {
        UserHomepageController controller = new UserHomepageController(userId);
        UserHomePageScreen screen = new UserHomePageScreen(controller);
    }

    public void createRestaurantHomepageScreen(ObjectId restaurantId, String restaurantName) {
        RestaurantHomepageController controller = new RestaurantHomepageController(restaurantId);
        RestaurantHomepageScreen screen = new RestaurantHomepageScreen(controller, restaurantName);
    }

    public JPanel createRestaurantOrderHistoryPanel(ObjectId currentRestaurantId, String restaurantName) {
        RestaurantOrderHistoryPresenter presenter =  new RestaurantOrderHistoryProcessor(null);
        RestaurantOrderHistoryInputBoundary interactor = new RestaurantOrderHistoryInteractor(presenter);
        RestaurantOrderHistoryController controller = new RestaurantOrderHistoryController(interactor, currentRestaurantId);

        RestaurantOrderHistoryPanelInterface panel = new RestaurantOrderHistoryPanel(controller, restaurantName);

        presenter.setScreen(panel);
        panel.updateOrder();

        OrderWatcherSingleton.setOrderWatcherSingletonInstance(new OrderWatcherSingleton(new OrderWatcher(presenter, currentRestaurantId)));
        OrderWatcherSingleton.getOrderWatcherSingletonInstance().getOrderWatcher().start();

        return (JPanel) panel;
    }

    public JPanel createRestaurantProfilePanel(ObjectId currentRestaurantId) {
        RestaurantProfilePresenter presenter =  new RestaurantProfileProcessor(null);
        RestaurantProfileInputBoundary interactor = new RestaurantProfileIneractor(presenter);
        RestaurantProfileController controller = new RestaurantProfileController(interactor, currentRestaurantId);

        RestaurantProfilePanel panel = new RestaurantProfilePanel(controller);
        presenter.setRestaurantProfilePanel(panel);
        panel.updatePanelData();

        return panel;
    }

    public JPanel createRestaurantDisplayMenuPanel(ObjectId currentRestaurantId) {
        ResDisplayMenuPresenter presenter = new ResDisplayMenuProcessor(null);
        ResDisplayMenuInputBoundary interactor = new ResDisplayMenuInteractor(presenter);
        ResDisplayMenuController controller = new ResDisplayMenuController(interactor, currentRestaurantId);

        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(controller.getRestId());
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(controller.getRestId());
        MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, controller.getRestId());


        ResDisplayMenuPanelInterface displayMenuPanel = new ResDisplayMenuPanel(controller, controller1);
        presenter.setDisplayMenuPanel(displayMenuPanel);
        displayMenuPanel.updatePanelData();

        return (JPanel) displayMenuPanel;
    }

    public void createAddFoodScreen(ObjectId restaurantId) {
        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(restaurantId);
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(restaurantId);
        MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, restaurantId);

        new AddFoodScreen(controller1);
    }

    public void createFoodEditingScreen(ObjectId restaurantId, String foodName, String foodCategory, String foodDescription, String foodPrice, ObjectId foodId) {
        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(restaurantId);
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(restaurantId);
        MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, restaurantId);

        new FoodEditingScreen(controller1, foodName, foodCategory, foodDescription, foodPrice, foodId);
    }

    public void createUpdateOrderStatusScreen(ObjectId orderId) {
        UpdateOrderStatusPresenter orderStatusPresenter = new UpdateOrderStatusProcessor(null);
        UpdateOrderStatusInputBoundary orderStatusInteractor = new UpdateOrderStatusInteractor(orderStatusPresenter);
        UpdateOrderStatusController orderStatusController = new UpdateOrderStatusController(orderStatusInteractor, orderId);
        UpdateOrderStatusScreenInterface screen = new UpdateOrderStatusScreen(orderStatusController);

        orderStatusPresenter.setScreen(screen);
        screen.getFrame().setVisible(true);
    }

    public void createOrderDetailScreen(ArrayList<HashMap<String, Object>> orderInfo) {
        new OrderHistoryDetailScreen(orderInfo);
    }

    public void createChangePasswordScreen(ObjectId userId) {
        ChangePasswordPresenter changePasswordPresenter = new ChangePasswordProcessor(null);
        ChangePasswordInputBoundary changePasswordInputBoundary = new ChangePasswordInteractor(changePasswordPresenter);
        ChangePasswordController changePasswordController = new ChangePasswordController(
                changePasswordInputBoundary,
                userId);

        ChangePasswordScreenInterface changePasswordScreen = new ChangePasswordScreen(changePasswordController);

        changePasswordPresenter.setChangePasswordScreenInterface(changePasswordScreen);

        changePasswordScreen.getFrame().setVisible(true);
    }

    public void createChangeRestaurantInfoScreen(ObjectId restaurantId) {
        ChangeRestaurantInfoPresenter changeRestaurantInfoPresenter = new ChangeRestaurantInfoProcessor(null);
        ChangeRestaurantInfoInputBoundary changeRestaurantInfoInputBoundary = new ChangeRestaurantInfoInteractor(changeRestaurantInfoPresenter);
        ChangeRestaurantInfoController changeRestaurantInfoController = new ChangeRestaurantInfoController(
                changeRestaurantInfoInputBoundary,
                restaurantId);

        ChangeRestaurantInfoScreenInterface changeRestaurantInfoScreen = new ChangeRestaurantInfoScreen(changeRestaurantInfoController);

        changeRestaurantInfoPresenter.setScreen(changeRestaurantInfoScreen);

        changeRestaurantInfoScreen.getFrame().setVisible(true);
    }

    public JPanel createUserDisplayMenu(ObjectId restaurantId) {
        DisplayMenuPresenter presenter = new DisplayMenuProcessor(null);
        DisplayMenuInputBoundary interactor = new DisplayMenuInteractor(presenter);
        DisplayMenuController controller = new DisplayMenuController(interactor, restaurantId);

        DisplayMenuPanelInterface displayMenuPanel = new DisplayMenuPanel(controller);

        presenter.setDisplayMenuPanel(displayMenuPanel);
        displayMenuPanel.updatePanelData();

        return (JPanel) displayMenuPanel;
    }

    public JPanel createUserOrderHistoryPanel(ObjectId userId){
        OrderHistoryPresenter orderHistoryPresenter = new OrderHistoryProcessor(null);
        OrderHistoryInputBoundary orderHistoryInteractor = new OrderHistoryInteractor(orderHistoryPresenter);
        OrderHistoryController orderHistoryController = new OrderHistoryController(orderHistoryInteractor, userId);

        OrderHistoryPanelInterface orderHistoryPanel = new OrderHistoryPanel(orderHistoryController);

        orderHistoryPresenter.setOrderHistoryPanel(orderHistoryPanel);
        orderHistoryPanel.updateOrder();

        return (JPanel) orderHistoryPanel;
    }

    public JPanel createUserDisplayRestaurantsPanel(ObjectId userId) {
        UserDisplayRestaurantPresenter userDisplayRestaurantPresenter = new UserDisplayRestaurantProcessor(null);
        UserDisplayRestaurantInputBoundary userDisplayRestaurantInteractor = new UserDisplayRestaurantInteractor(userDisplayRestaurantPresenter);
        UserSearchRestaurantInputBoundary userSearchRestaurantInteractor = new UserSearchRestaurantInteractor(userDisplayRestaurantPresenter);
        UserDisplayRestaurantController userDisplayRestaurantController = new UserDisplayRestaurantController(userDisplayRestaurantInteractor, userSearchRestaurantInteractor);

        UserDisplayRestaurantPanelInterface screen = new UserDisplayRestaurantPanel(userDisplayRestaurantController);

        userDisplayRestaurantPresenter.setScreen(screen);

        screen.refreshData();

        return (JPanel) screen;
    }

    public JPanel getShoppingCartPanel(ObjectId userId) {
        ShoppingCartPresenter shoppingCartPresenter = new ShoppingCartProcessor(null);
        CheckoutPresenter checkoutPresenter = new CheckoutProcessor(null);
        ShoppingCartInputBoundary shoppingCartInputBoundary = new ShoppingCartInteractor(shoppingCartPresenter);
        CheckoutInputBoundary checkoutInputBoundary = new CheckoutInteractor(checkoutPresenter);
        ShoppingCartController shoppingCartController = new ShoppingCartController(shoppingCartInputBoundary, checkoutInputBoundary, userId);

        ShoppingCartPanelInterface screen = new ShoppingCartPanel(shoppingCartController);

        checkoutPresenter.setScreen(screen);
        shoppingCartPresenter.setScreen(screen);

        screen.refreshData();

        return (JPanel) screen;
    }

    public JPanel createUserProfilePanel(ObjectId userId){
        UserProfilePresenter userProfilePresenter = new UserProfileProcessor(null);
        UserProfileInputBoundary userProfileInteractor = new UserProfileInteractor(userProfilePresenter);
        UserProfileController userProfileController = new UserProfileController(userProfileInteractor, userId);

        UserProfilePanelInterface userProfilePanel = new UserProfilePanel(userProfileController);


        userProfilePresenter.setUserProfilePanel(userProfilePanel);
        userProfilePanel.updatePanelData();

        return (JPanel)userProfilePanel;
    }

    public void createMakeReviewScreen(ObjectId orderId) {
        MakeReviewPresenter presenter = new MakeReviewResponseFormatter();
        MakeReviewInputBoundary inputBoundary = new ReviewInteractor(presenter);
        MakeReviewController makeReviewController = new MakeReviewController(inputBoundary, orderId);
        MakeReviewScreen screen = new MakeReviewScreen(makeReviewController);
        screen.setVisible(true);
    }

    public void createChangeUserInfoScreen(ObjectId userId) {
        ChangeUserInfoPresenter changeUserInfoPresenter = new ChangeUserInfoProcessor(null);
        ChangeUserInfoInputBoundary changeUserInfoInputBoundary = new ChangeUserInfoInteractor(changeUserInfoPresenter);
        ChangeUserInfoController changeUserInfoController = new ChangeUserInfoController(
                changeUserInfoInputBoundary,
                userId);

        ChangeUserInfoScreenInterface changeUserInfoScreen = new ChangeUserInfoScreen(changeUserInfoController);

        changeUserInfoPresenter.setScreen(changeUserInfoScreen);

        changeUserInfoScreen.getFrame().setVisible(true);
    }
}
