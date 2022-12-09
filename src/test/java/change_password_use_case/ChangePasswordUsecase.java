package change_password_use_case;

import database.AuthInfoDataGateway;
import database.AuthInfoProcessorMongo;
import database.MongoCollectionFetcher;
import entities.AuthInfo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * We are only testing the controller because other methods and classes can be reached by controller.
 */

class ChangePasswordTest {
    MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
    ObjectId userId = new ObjectId("63797394ee00665db6a0a950");

    ChangePasswordOutputBoundary changePasswordOutputBoundary = new ChangePasswordPresenter(null);
    ChangePasswordInputBoundary changePasswordInputBoundary = new ChangePasswordInteractor(changePasswordOutputBoundary);
    ChangePasswordController changePasswordController = new ChangePasswordController(
            changePasswordInputBoundary,
            userId);

    ChangePasswordScreenInterface changePasswordScreen = new ChangePasswordScreen(changePasswordController);

    @BeforeEach
    void setUp(){
        changePasswordOutputBoundary.setChangePasswordScreenInterface(changePasswordScreen);


    }

    @AfterEach
    void tearDown(){
        changePasswordController.changePassword("234567", "123456", "123456");
    }

    @Test
    void testChangePassword(){
        changePasswordController.changePassword("123456", "234567", "234567");

        changePasswordOutputBoundary.setChangePasswordScreenInterface(changePasswordScreen);
        AuthInfoDataGateway gateway = new AuthInfoProcessorMongo(fetcher);
        AuthInfo info = gateway.getUserByUsername("yinuo's res");

        Assertions.assertEquals(info.getPassword(), "2dc0269fa54d269a87536810ec453cb095b4b92f45e63826a21dff1c2e76f169");
    }
}