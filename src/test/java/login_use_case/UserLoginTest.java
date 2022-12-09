package login_use_case;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class is the test of user login use case.
 */
class UserLoginTest {

    ObjectId resId = new ObjectId("6392a48f5bfef323e3d5c00d");
    UserLoginOutputBoundary userLoginOutputBoundary = new UserLoginPresenter(null);
    UserLoginInputBoundary userLoginInteractor = new UserLoginInteractor(userLoginOutputBoundary);
    RestaurantLoginInputBoundary restaurantLoginInteractor = new RestaurantLoginInteractor(userLoginOutputBoundary);
    UserLoginController userLoginController = new UserLoginController(userLoginInteractor, restaurantLoginInteractor);
    UserLoginScreenInterface screen = new UserLoginScreen(userLoginController);

    @BeforeEach
    void setUp() {
        userLoginOutputBoundary.setLoginScreen(screen);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testLogin() {
        RestaurantLoginRequestModel requestModel = new RestaurantLoginRequestModel("InorTestingRes", "cptbtptp");
        UserLoginResponseModel responseModel = restaurantLoginInteractor.login(requestModel);
        Assertions.assertEquals(responseModel.getUserId(), resId);
    }
}