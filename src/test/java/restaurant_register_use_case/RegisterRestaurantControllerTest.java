package restaurant_register_use_case;

import database.MongoCollectionFetcher;
import database.RestaurantDataGateway;
import database.RestaurantDataMongo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entities.*;

class RegisterRestaurantControllerTest {

    MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
    RestaurantDataGateway gateway = new RestaurantDataMongo(fetcher);
    RegisterRestaurantOutputBoundary registerRestaurantOutputBoundary = new RegisterRestaurantPresenter(null);
    RegisterRestaurantInputBoundary registerRestaurantInputBoundary = new RegisterRestaurantInteractor(registerRestaurantOutputBoundary);
    RegisterRestaurantController registerRestaurantController = new RegisterRestaurantController(registerRestaurantInputBoundary);
    RegisterRestaurantScreenInterface screen = new RegisterRestaurantScreen(registerRestaurantController);

    ObjectId newResId;

    @BeforeEach
    void setUp() {
        registerRestaurantOutputBoundary.setScreen(screen);
    }

    @AfterEach
    void tearDown() {
        gateway.removeResById(newResId);
    }

    @Test
    void testRegisterRes(){
        registerRestaurantController.register("testResssss", "testRes", "123456", "yinuozhao959@gmail.com", "uoft", "7781234567");
        Assertions.assertNotNull(gateway.findByRestaurantName("testResssss"));
        Restaurant res = gateway.findByRestaurantName("testResssss").get(0);
        newResId = res.getRestaurantID();
    }
}