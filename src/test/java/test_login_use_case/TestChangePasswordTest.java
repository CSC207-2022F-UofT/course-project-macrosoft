package test_login_use_case;

import login_use_case.RestaurantLoginInputBoundary;
import login_use_case.UserLoginController;
import login_use_case.UserLoginInputBoundary;
import login_use_case.UserLoginResponseModel;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


class TestUserLogin extends UserLoginController {

    public TestUserLogin(UserLoginInputBoundary userInput, RestaurantLoginInputBoundary restaurantInput) {
        super(userInput, restaurantInput);
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void testLoginValidUser() {
        UserLoginResponseModel responseModel = super.login("davidlin123", "lzy123456");
        Assertions.assertEquals(responseModel.getResponseCode(), 1000);
    }

    @AfterEach
    void tearDown() {

    }
}