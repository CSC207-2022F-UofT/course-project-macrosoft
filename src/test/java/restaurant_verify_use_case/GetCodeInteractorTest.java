package restaurant_verify_use_case;

import database.MongoCollectionFetcher;

import entities.VerificationCode;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import database.VerificationCodeProcessorMongo;
import database.VerificationCodeDataGateway;
import user_verify_use_case.GetCodeInteractor;

import static org.junit.jupiter.api.Assertions.*;


class GetCodeInteractorTest {

    // setting up a test restaurant with verification code 123456 at the current time
    @BeforeEach
    void setUp() {
        ObjectId resID = new ObjectId("638fd7e653160338d1041386");
        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        VerificationCode code = new VerificationCode(date, "123456");

        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.save(resID, code);

    }

    // removing the test restaurant from the database after the tests have been run

    @AfterEach
    void tearDown() {
        ObjectId resID = new ObjectId("638fd7e653160338d1041386");
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway verificationCodeDataGateway = new VerificationCodeProcessorMongo(fetcher);
        verificationCodeDataGateway.deleteByUserId(resID);
    }

    /* testing get verification code for an existing restaurant, testing to see if method can get the
     correct verification code from the database */


    @Test
    void getVerificationCodeTrue() {

        ObjectId resID = new ObjectId("638fd7e653160338d1041386");
        String actual = "123456";

        assertTrue(user_verify_use_case.GetCodeInteractor.getVerificationCode(resID).equals(actual));
    }

    //testing get verification code for a restaurant that does not exist
    //restaurant id does not exist in the database, so it should return empty string
    @Test
    void getVerificationCodeFalse() {
        String actual = "";
        ObjectId resID = new ObjectId("638fd7e653160338d10413b9");
        assertTrue(GetCodeInteractor.getVerificationCode(resID).equals(actual));
    }


}