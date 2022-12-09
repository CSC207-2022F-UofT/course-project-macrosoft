package test_user_verify_use_case;

import database.MongoCollectionFetcher;
import entities.VerificationCode;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import database.VerificationCodeProcessorMongo;
import database.VerificationCodeDataGateway;
import user_verify_use_case.GetCodeInteractor;

import static org.junit.jupiter.api.Assertions.*;


class GetCodeInteractorTest {

    // setting up a test user with verification code 898912 at the current time
    @BeforeEach
    void setUp() {
        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        VerificationCode code = new VerificationCode(date,"898912");

        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.save(userID, code);
    }

    // removing the test user from the database after the tests have been run

    @AfterEach
    void tearDown() {
        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.deleteByUserId(userID);
    }

    /* testing get verification code for an existing user, testing to see if method can get the
     correct verification code from the database */


    @Test
    void getVerificationCodeTrue() {

        ObjectId userID = new ObjectId("638fd7e653160338d10413bb");
        String actual = "898912";

        Assertions.assertTrue(GetCodeInteractor.getVerificationCode(userID).equals(actual));
    }

    //testing get verification code for a user that does not exist
    //user id does not exist in the database, so it should return empty string
    @Test
    void getVerificationCodeFalse() {
        String actual = "";
        ObjectId userID = new ObjectId("638fd7e653160338d10413b9");
        assertTrue(GetCodeInteractor.getVerificationCode(userID).equals(actual));
    }


}