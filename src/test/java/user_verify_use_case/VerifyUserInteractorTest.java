package user_verify_use_case;

import database.MongoCollectionFetcher;
import database.VerificationCodeDataGateway;
import database.VerificationCodeProcessorMongo;
import entities.VerificationCode;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class VerifyUserInteractorTest {


    // setting up a test document in our database
//    @BeforeEach
//    void setUp() {
//
//        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
//        long millis = System.currentTimeMillis();
//        java.util.Date date = new java.util.Date(millis);
//        VerificationCode code = new VerificationCode(date,"898912");
//
//        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
//        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
//        verificationCodeDataGateway.save(userID, code);
//    }
//    // removing the test document from database after tests are run
//    @AfterEach
//    void tearDown() {
//        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
//        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
//        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
//        verificationCodeDataGateway.deleteByUserId(userID);
//    }
//    // testing verify user interactor with a valid code
//    @Test
//    void testVerifyUserValid() {
//        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
//        int actual = 1000;
//        VerifyUserPresenter verifyUserPresenter = new VerifyUserProcessor(null);
//        VerifyUserFacade verifyUserFacade = new VerifyUserFacade(verifyUserPresenter);
//        VerifyUserController verifyUserController = new VerifyUserController(verifyUserFacade, userID);
//        VerifyUserScreenInterface verifyUserScreen = new VerifyUserScreen(verifyUserController);
//
//        verifyUserPresenter.setVerifyUserScreen(verifyUserScreen);
//        verifyUserScreen.getFrame().setVisible(true);
//
//
//        VerifyUserInteractor verifyUserInteractor = new VerifyUserInteractor(verifyUserPresenter);
//        assertEquals(verifyUserInteractor.verifyUser(userID,"898912"), actual);
//
//    }
//
//    // testing verify user interactor with an invalid code
//    @Test
//    void testVerifyUserInvalid() {
//        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
//        int actual = 1001;
//
//        VerifyUserPresenter verifyUserPresenter = new VerifyUserProcessor(null);
//        VerifyUserFacade verifyUserFacade = new VerifyUserFacade(verifyUserPresenter);
//        VerifyUserController verifyUserController = new VerifyUserController(verifyUserFacade, userID);
//        VerifyUserScreenInterface verifyUserScreen = new VerifyUserScreen(verifyUserController);
//
//        verifyUserPresenter.setVerifyUserScreen(verifyUserScreen);
//        verifyUserScreen.getFrame().setVisible(true);
//
//
//        VerifyUserInteractor verifyUserInteractor = new VerifyUserInteractor(verifyUserPresenter);
//        assertEquals(verifyUserInteractor.verifyUser(userID,"898913"), actual);
//
//    }

}