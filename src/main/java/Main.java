import database.MongoCollectionFetcher;
import database.RestaurantDataGateway;
import database.RestaurantDataMongo;
import entities.Restaurant;

public class Main {
    public static void main(String[] args) {

        MongoCollectionFetcher fetcher = new MongoCollectionFetcher();
        RestaurantDataGateway restaurantDataGateway = new RestaurantDataMongo(fetcher);

        for (Restaurant restaurant: restaurantDataGateway.findByRestaurantName("McD")) {
            System.out.println(restaurant.getName());
        }
//        // Build the main program window
//        JFrame application = new JFrame("Login Example");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//
//
//        // Build the GUI, plugging in the parts
//
//        UserLoginInputBoundary interactor = new UserLoginInteractor();
//        UserLoginController userLoginController = new UserLoginController(interactor);
//
//        LoginPresenter loginPresenter = new LoginPresenter(userLoginController);
//
//        screens.add(loginPresenter.getContentPane(), "login");
//        cardLayout.show(screens, "login");
//        application.pack();
//        application.setVisible(true);

//         Unused screens; we'll uncomment this later
//        WelcomeScreen welcomeScreen = new WelcomeScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        LoggedInScreen loggedInScreen = new LoggedInScreen();
//        screens.add(welcomeScreen, "register");
//        screens.add(loginScreen, "login");
//        screens.add(loggedInScreen, "loggedIn");


//        RegisterRestaurantInteractor.registerRestaurant("yinuo's res", "cptbtptp", "123@gmail.com", "UofT", "6041234567");
//        LoginRestaurantInteractor.login("yinuo's res", "cptbtptp");
//        ObjectId resId = LoginRestaurantInteractor.getCurrentRestaurant().getRestaurantID();
//        Menu curMenu = GetMenuInteractor.getMenu(resId);
//        System.out.println(LoginRestaurantInteractor.getCurrentRestaurant().getName());
//        ObjectId resId = LoginRestaurantInteractor.getCurrentRestaurant().getRestaurantID();

//        Menu curMenu = GetMenuInteractor.getMenu(new ObjectId("63797394ee00665db6a0a950")); //restaurantID
//        AddFoodInteractor.add(curMenu, "Ice Cream", "best for summer!", "sweets", 10.00f);
//        AddFoodInteractor.add(curMenu, "Gelato", "bruhhh", "sweets", 14.00f);
//        AddFoodInteractor.add(curMenu, "Apple", "poisonous", "fruit", 2f);
//        AddFoodInteractor.add(curMenu, "Burger", "bigbigbigburger", "main", 10.00f);
//        AddFoodInteractor.add(curMenu, "Steak", "raw", "main", 80.00f);
//        AddFoodInteractor.add(curMenu, "Salad", "very healthy", "appetizer", 25.00f);
//        AddFoodInteractor.add(curMenu, "Peach", "pink", "fruit", 5.00f);
//        AddFoodInteractor.add(curMenu, "Water", "bottled", "drink", 5.00f);
//        AddFoodInteractor.add(curMenu, "Cookie", "freshly baked", "sweets", 5.00f);

//        Food f1 = new Food("Gelato", "bruhhh", "sweets", 14.00f, new ObjectId("637993ddb31b3253d8247e2c"));
//        Food f2 = new Food("Ice Cream", "best for summer!", "sweets", 10.00f, new ObjectId("6379947d89a3ef24fc3af381"));
//        RemoveFoodInteractor.remove(curMenu,f1);
//        EditNameInteractor.modifyName(curMenu, f2, "Brownie");


    }

}