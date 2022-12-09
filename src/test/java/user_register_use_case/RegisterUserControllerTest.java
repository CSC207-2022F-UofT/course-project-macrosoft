package user_register_use_case;

import database.*;
import entities.Restaurant;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterUserControllerTest {

    MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();

    AuthInfoDataGateway gateway = new AuthInfoProcessorMongo(fetcher);
    RegisterUserOutputBoundary registerUserOutputBoundary = new RegisterUserPresenter(null);
    RegisterUserInputBoundary registerUserInputBoundary = new RegisterUserInteractor(registerUserOutputBoundary);
    RegisterUserController registerUserController = new RegisterUserController(registerUserInputBoundary);
    RegisterUserScreenInterface screen = new RegisterUserScreen(registerUserController);


    @BeforeEach
    void setUp() {
        registerUserOutputBoundary.setScreen(screen);
    }

    @AfterEach
    void tearDown() {
        gateway.removeByUsername("testUserrrrrr");
    }

    @Test
    void testRegisterUser(){
        RegisterUserRequestModel request = new RegisterUserRequestModel("yinuozhao959@gmail.com","testUserrrrrr", "testUser", "testUser", "testUser");
        int num = registerUserInputBoundary.registerUser(request);
        Assertions.assertEquals(num, 1000);
    }
}