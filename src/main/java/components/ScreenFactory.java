package components;

import change_password_use_case.*;
import change_restaurant_info_use_case.*;
import change_user_info_use_case.*;
import login_use_case.*;
import menu_editing_use_case.*;
import menu_editing_use_case.AddFoodScreen;
import menu_editing_use_case.FoodEditingScreen;
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
import welcome_use_case.WelcomeScreenController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

// Responsibility: create screen

/**
 * This class is the factory of the screen
 */
public class ScreenFactory {

    /**
     * Create welcome screen
     */
    public void createWelcomeScreen() {

        WelcomeScreenController controller = new WelcomeScreenController();
        WelcomeScreen screen = new WelcomeScreen(controller);
    }

    /**
     * Create login screen
     */
    public void createLoginSreen() {
        UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter(null);
        UserLoginInputBoundary userLoginInteractor = new UserLoginInteractor(userLoginOutputBoundary);
        RestaurantLoginInputBoundary restaurantLoginInteractor = new RestaurantLoginInteractor(userLoginOutputBoundary);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor, restaurantLoginInteractor);
        UserLoginScreenInterface screen = new UserLoginScreen(userLoginController);
        userLoginOutputBoundary.setLoginScreen(screen);
        screen.getFrame().setVisible(true);
    }

    /**
     * Create user register screen
     */
    public void createUserRegisterScreen() {
        RegisterUserOutputBoundary registerUserOutputBoundary = new RegisterUserPresenter(null);
        RegisterUserInputBoundary registerUserInputBoundary = new RegisterUserInteractor(registerUserOutputBoundary);
        RegisterUserController registerUserController = new RegisterUserController(registerUserInputBoundary);
        RegisterUserScreenInterface screen = new RegisterUserScreen(registerUserController);
        registerUserOutputBoundary.setScreen(screen);
        screen.getFrame().setVisible(true);
    }

    /**
     * Create restaurant register screen
     */
    public void createRestaurantRegisterScreen() {
        RegisterRestaurantOutputBoundary registerRestaurantOutputBoundary = new RegisterRestaurantPresenter(null);
        RegisterRestaurantInputBoundary registerRestaurantInputBoundary = new RegisterRestaurantInteractor(registerRestaurantOutputBoundary);
        RegisterRestaurantController registerRestaurantController = new RegisterRestaurantController(registerRestaurantInputBoundary);
        RegisterRestaurantScreenInterface screen = new RegisterRestaurantScreen(registerRestaurantController);
        registerRestaurantOutputBoundary.setScreen(screen);
        screen.getFrame().setVisible(true);
    }

    /**
     * Create user verify screen with the given user id
     *
     * @param userId the user id
     */
    public void createVerifyUserScreen(ObjectId userId) {
        VerifyUserOutputBoundary verifyUserOutputBoundary = new VerifyUserPresenter(null);
        VerifyUserFacade verifyUserFacade = new VerifyUserFacade(verifyUserOutputBoundary);
        VerifyUserController verifyUserController = new VerifyUserController(verifyUserFacade, userId);
        VerifyUserScreenInterface verifyUserScreen = new VerifyUserScreen(verifyUserController);

        verifyUserOutputBoundary.setVerifyUserScreen(verifyUserScreen);

        verifyUserScreen.getFrame().setVisible(true);
    }

    /**
     * Create restaurant verify screen with the given restaurant id
     *
     * @param restaurantId the restaurant id
     */
    public void createVerifyRestaurantScreen(ObjectId restaurantId) {
        VerifyResOutputBoundary verifyResOutputBoundary = new VerifyResPresenter(null);
        VerifyResFacade verifyResFacade = new VerifyResFacade(verifyResOutputBoundary);
        VerifyResController verifyResController = new VerifyResController(verifyResFacade, restaurantId);
        VerifyResScreenInterface verifyResScreen = new VerifyResScreen(verifyResController);

        verifyResOutputBoundary.setVerifyResScreenInterface(verifyResScreen);

        verifyResScreen.getFrame().setVisible(true);
    }

    /**
     * Create user homepage screen with the given user id
     *
     * @param userId the user id
     */
    public void createUserHomepageScreen(ObjectId userId) {
        UserHomepageController controller = new UserHomepageController(userId);
        UserHomePageScreen screen = new UserHomePageScreen(controller);
    }

    /**
     * Create restaurant homepage screen with the given restaurant id and restaurant name
     *
     * @param restaurantId   the restaurant id
     * @param restaurantName the restaurant name
     */
    public void createRestaurantHomepageScreen(ObjectId restaurantId, String restaurantName) {
        RestaurantHomepageController controller = new RestaurantHomepageController(restaurantId);
        RestaurantHomepageScreen screen = new RestaurantHomepageScreen(controller, restaurantName);
    }

    /**
     * Create restaurant order history screen with the given restaurant id and restaurant name
     *
     * @param currentRestaurantId the restaurant id
     * @param restaurantName      the restaurant name
     * @return the restaurant order history screen
     */
    public JPanel createRestaurantOrderHistoryPanel(ObjectId currentRestaurantId, String restaurantName) {
        RestaurantOrderHistoryOutputBoundary presenter = new RestaurantOrderHistoryPresenter(null);
        RestaurantOrderHistoryInputBoundary interactor = new RestaurantOrderHistoryInteractor(presenter);
        RestaurantOrderHistoryController controller = new RestaurantOrderHistoryController(interactor, currentRestaurantId);

        RestaurantOrderHistoryPanelInterface panel = new RestaurantOrderHistoryPanel(controller, restaurantName);

        presenter.setScreen(panel);
        panel.updateOrder();

        OrderWatcherSingleton.setOrderWatcherSingletonInstance(new OrderWatcherSingleton(new OrderWatcher(presenter, currentRestaurantId)));
        OrderWatcherSingleton.getOrderWatcherSingletonInstance().getOrderWatcher().start();

        return (JPanel) panel;
    }

    /**
     * Create restaurant profile screen with the given restaurant id
     *
     * @param currentRestaurantId the restaurant id
     * @return the restaurant profile screen
     */
    public JPanel createRestaurantProfilePanel(ObjectId currentRestaurantId) {
        RestaurantProfileOutputBoundary presenter = new RestaurantProfilePresenter(null);
        RestaurantProfileInputBoundary interactor = new RestaurantProfileIneractor(presenter);
        RestaurantProfileController controller = new RestaurantProfileController(interactor, currentRestaurantId);

        RestaurantProfilePanel panel = new RestaurantProfilePanel(controller);
        presenter.setRestaurantProfilePanel(panel);
        panel.updatePanelData();

        return panel;
    }

    /**
     * Create restaurant menu screen with the given restaurant id
     *
     * @param currentRestaurantId the restaurant id
     * @return the restaurant menu screen
     */
    public JPanel createRestaurantDisplayMenuPanel(ObjectId currentRestaurantId) {
        ResDisplayMenuOutputBoundary presenter = new ResDisplayMenuPresenter(null);
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

    /**
     * Create add food screen with the given restaurant id
     *
     * @param restaurantId the restaurant id
     */
    public void createAddFoodScreen(ObjectId restaurantId) {
        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(restaurantId);
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(restaurantId);
        MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, restaurantId);

        new AddFoodScreen(controller1);
    }

    /**
     * Create edit food screen
     *
     * @param restaurantId    the restaurant id
     * @param foodName        the food name
     * @param foodCategory    the food category
     * @param foodDescription the food description
     * @param foodPrice       the food price
     * @param foodId          the food id
     */
    public void createFoodEditingScreen(ObjectId restaurantId, String foodName, String foodCategory, String foodDescription, String foodPrice, ObjectId foodId) {
        AddFoodInputBoundary interactor_add = new MenuEditingInteractor(restaurantId);
        RemoveFoodInputBoundary interactor_remove = new MenuEditingInteractor(restaurantId);
        MenuEditingController controller1 = new MenuEditingController(interactor_add, interactor_remove, restaurantId);

        new FoodEditingScreen(controller1, foodName, foodCategory, foodDescription, foodPrice, foodId);
    }

    /**
     * Create update order status screen with the given order id
     *
     * @param orderId the order id
     */
    public void createUpdateOrderStatusScreen(ObjectId orderId) {
        UpdateOrderStatusOutputBoundary orderStatusPresenter = new UpdateOrderStatusPresenter(null);
        UpdateOrderStatusInputBoundary orderStatusInteractor = new UpdateOrderStatusInteractor(orderStatusPresenter);
        UpdateOrderStatusController orderStatusController = new UpdateOrderStatusController(orderStatusInteractor, orderId);
        UpdateOrderStatusScreenInterface screen = new UpdateOrderStatusScreen(orderStatusController);

        orderStatusPresenter.setScreen(screen);
        screen.getFrame().setVisible(true);
    }

    /**
     * Create order detail screen with the given order information
     *
     * @param orderInfo the order information
     */
    public void createOrderDetailScreen(ArrayList<HashMap<String, Object>> orderInfo) {
        new OrderHistoryDetailScreen(orderInfo);
    }

    /**
     * Create change password screen with the given user id
     *
     * @param userId the user id
     */
    public void createChangePasswordScreen(ObjectId userId) {
        ChangePasswordOutputBoundary changePasswordOutputBoundary = new ChangePasswordPresenter(null);
        ChangePasswordInputBoundary changePasswordInputBoundary = new ChangePasswordInteractor(changePasswordOutputBoundary);
        ChangePasswordController changePasswordController = new ChangePasswordController(
                changePasswordInputBoundary,
                userId);

        ChangePasswordScreenInterface changePasswordScreen = new ChangePasswordScreen(changePasswordController);

        changePasswordOutputBoundary.setChangePasswordScreenInterface(changePasswordScreen);

        changePasswordScreen.getFrame().setVisible(true);
    }

    /**
     * Create change restaurant information screen with the given restaurant id
     *
     * @param restaurantId the restaurant id
     */
    public void createChangeRestaurantInfoScreen(ObjectId restaurantId) {
        ChangeRestaurantInfoOutputBoundary changeRestaurantInfoOutputBoundary = new ChangeRestaurantInfoPresenter(null);
        ChangeRestaurantInfoInputBoundary changeRestaurantInfoInputBoundary = new ChangeRestaurantInfoInteractor(changeRestaurantInfoOutputBoundary);
        ChangeRestaurantInfoController changeRestaurantInfoController = new ChangeRestaurantInfoController(
                changeRestaurantInfoInputBoundary,
                restaurantId);

        ChangeRestaurantInfoScreenInterface changeRestaurantInfoScreen = new ChangeRestaurantInfoScreen(changeRestaurantInfoController);

        changeRestaurantInfoOutputBoundary.setScreen(changeRestaurantInfoScreen);

        changeRestaurantInfoScreen.getFrame().setVisible(true);
    }

    /**
     * Create user display menu screen with the given restaurant id
     *
     * @param restaurantId the restaurant id
     * @return the user display menu screen
     */
    public JPanel createUserDisplayMenu(ObjectId restaurantId) {
        DisplayMenuOutputBoundary presenter = new DisplayMenuPresenter(null);
        DisplayMenuInputBoundary interactor = new DisplayMenuInteractor(presenter);
        DisplayMenuController controller = new DisplayMenuController(interactor, restaurantId);

        DisplayMenuPanelInterface displayMenuPanel = new DisplayMenuPanel(controller);

        presenter.setDisplayMenuPanel(displayMenuPanel);
        displayMenuPanel.updatePanelData();

        return (JPanel) displayMenuPanel;
    }

    /**
     * Create user order history screen with the given user id
     *
     * @param userId the user id
     * @return the user order history screen
     */
    public JPanel createUserOrderHistoryPanel(ObjectId userId) {
        OrderHistoryOutputBoundary orderHistoryOutputBoundary = new OrderHistoryPresenter(null);
        OrderHistoryInputBoundary orderHistoryInteractor = new OrderHistoryInteractor(orderHistoryOutputBoundary);
        OrderHistoryController orderHistoryController = new OrderHistoryController(orderHistoryInteractor, userId);

        OrderHistoryPanelInterface orderHistoryPanel = new OrderHistoryPanel(orderHistoryController);

        orderHistoryOutputBoundary.setOrderHistoryPanel(orderHistoryPanel);
        orderHistoryPanel.updateOrder();

        return (JPanel) orderHistoryPanel;
    }

    /**
     * Create user display restaurant screen with the given user id
     *
     * @param userId the user id
     * @return the user display restaurant screen
     */
    public JPanel createUserDisplayRestaurantsPanel(ObjectId userId) {
        UserDisplayRestaurantOutputBoundary userDisplayRestaurantOutputBoundary = new UserDisplayRestaurantPresenter(null);
        UserDisplayRestaurantInputBoundary userDisplayRestaurantInteractor = new UserDisplayRestaurantInteractor(userDisplayRestaurantOutputBoundary);
        UserSearchRestaurantInputBoundary userSearchRestaurantInteractor = new UserSearchRestaurantInteractor(userDisplayRestaurantOutputBoundary);
        UserDisplayRestaurantController userDisplayRestaurantController = new UserDisplayRestaurantController(userDisplayRestaurantInteractor, userSearchRestaurantInteractor);

        UserDisplayRestaurantPanelInterface screen = new UserDisplayRestaurantPanel(userDisplayRestaurantController);

        userDisplayRestaurantOutputBoundary.setScreen(screen);

        screen.refreshData();

        return (JPanel) screen;
    }

    /**
     * Gets shopping cart panel by user id
     *
     * @param userId user id
     * @return JPanel
     */
    public JPanel getShoppingCartPanel(ObjectId userId) {
        ShoppingCartOutputBoundary shoppingCartOutputBoundary = new ShoppingCartPresenter(null);
        CheckoutPresenter checkoutPresenter = new CheckoutProcessor(null);
        ShoppingCartInputBoundary shoppingCartInputBoundary = new ShoppingCartInteractor(shoppingCartOutputBoundary);
        CheckoutInputBoundary checkoutInputBoundary = new CheckoutInteractor(checkoutPresenter);
        ShoppingCartController shoppingCartController = new ShoppingCartController(shoppingCartInputBoundary, checkoutInputBoundary, userId);

        ShoppingCartPanelInterface screen = new ShoppingCartPanel(shoppingCartController);

        checkoutPresenter.setScreen(screen);
        shoppingCartOutputBoundary.setScreen(screen);

        screen.refreshData();

        return (JPanel) screen;
    }

    /**
     * Create user search restaurant screen with the given user id
     *
     * @param userId the user id
     * @return the user search restaurant screen
     */
    public JPanel createUserProfilePanel(ObjectId userId) {
        UserProfileOutputBoundary userProfileOutputBoundary = new UserProfilePresenter(null);
        UserProfileInputBoundary userProfileInteractor = new UserProfileInteractor(userProfileOutputBoundary);
        UserProfileController userProfileController = new UserProfileController(userProfileInteractor, userId);

        UserProfilePanelInterface userProfilePanel = new UserProfilePanel(userProfileController);


        userProfileOutputBoundary.setUserProfilePanel(userProfilePanel);
        userProfilePanel.updatePanelData();

        return (JPanel) userProfilePanel;
    }

    /**
     * Create make review screen with the given order id
     *
     * @param orderId the order id
     */
    public void createMakeReviewScreen(ObjectId orderId) {
        MakeReviewOutputBoundary presenter = new MakeReviewPresenter();
        MakeReviewInputBoundary inputBoundary = new ReviewInteractor(presenter);
        MakeReviewController makeReviewController = new MakeReviewController(inputBoundary, orderId);
        MakeReviewScreen screen = new MakeReviewScreen(makeReviewController);
        screen.setVisible(true);
    }

    /**
     * Create change user information screen with the given user id
     *
     * @param userId the user id
     */
    public void createChangeUserInfoScreen(ObjectId userId) {
        ChangeUserInfoOutputBoundary changeUserInfoOutputBoundary = new ChangeUserInfoPresenter(null);
        ChangeUserInfoInputBoundary changeUserInfoInputBoundary = new ChangeUserInfoInteractor(changeUserInfoOutputBoundary);
        ChangeUserInfoController changeUserInfoController = new ChangeUserInfoController(
                changeUserInfoInputBoundary,
                userId);

        ChangeUserInfoScreenInterface changeUserInfoScreen = new ChangeUserInfoScreen(changeUserInfoController);

        changeUserInfoOutputBoundary.setScreen(changeUserInfoScreen);

        changeUserInfoScreen.getFrame().setVisible(true);
    }
}
