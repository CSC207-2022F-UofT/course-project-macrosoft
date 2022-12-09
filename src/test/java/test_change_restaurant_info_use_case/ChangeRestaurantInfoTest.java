package test_change_restaurant_info_use_case;

import change_restaurant_info_use_case.*;
import database.MongoCollectionFetcher;
import database.RestaurantDataGateway;
import database.RestaurantDataMongo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * We are only testing the controller because other methods and classes can be reached by controller.
 */
class ChangeRestaurantInfoTest {

    MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
    RestaurantDataGateway gateway = new RestaurantDataMongo(fetcher);

    ObjectId restaurantId = new ObjectId("63797394ee00665db6a0a950");

    ChangeRestaurantInfoOutputBoundary changeRestaurantInfoOutputBoundary;
    ChangeRestaurantInfoInputBoundary changeRestaurantInfoInputBoundary;
    ChangeRestaurantInfoController changeRestaurantInfoController;
    ChangeRestaurantInfoScreenInterface changeRestaurantInfoScreen;


    @BeforeEach
    void setUp() {
        changeRestaurantInfoOutputBoundary = new ChangeRestaurantInfoPresenter(null);
        changeRestaurantInfoInputBoundary = new ChangeRestaurantInfoInteractor(changeRestaurantInfoOutputBoundary);
        changeRestaurantInfoController = new ChangeRestaurantInfoController(
                changeRestaurantInfoInputBoundary,
                restaurantId);
        changeRestaurantInfoScreen = new ChangeRestaurantInfoScreen(changeRestaurantInfoController);
        changeRestaurantInfoOutputBoundary.setScreen(changeRestaurantInfoScreen);

    }

    @AfterEach
    void tearDown() {
        changeRestaurantInfoController.changeRestaurantInfo("yinuo's res", "yinuozhao959@gmail.com", "Eaton Centre", "6041238687");
    }

    @Test
    void testChangeResInfo()
    {
        changeRestaurantInfoController.changeRestaurantInfo("yinuo's res2", "yinuozhao959@gmail.com", "Eaton Centre", "6041238687");
        Assertions.assertEquals(gateway.getRestaurantNameById(restaurantId), "yinuo's res2");
    }
}