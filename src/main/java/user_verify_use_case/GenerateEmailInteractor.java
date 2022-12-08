package user_verify_use_case;

import database.*;
import entities.User;
import entities.VerificationCode;
import org.bson.types.ObjectId;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * This class is the interactor of generate email.
 */
public class GenerateEmailInteractor {
    /**
     * Generate verification email.
     *
     * @param userId the user id of user
     */
    public void generateVerificationEmail(ObjectId userId) {
        MongoCollectionFetcher fetcher = MongoCollectionFetcher.getFetcher();
        VerificationCodeDataGateway dataGateway = new VerificationCodeProcessorMongo(fetcher);
        UserDataGateway userDataGateway = new UserDataProcessorMongo(fetcher);

        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String verificationCode = String.format("%06d", number);

        String existingCode = GetCodeInteractor.getVerificationCode(userId);

        if (existingCode.isEmpty()) {
            dataGateway.save(userId, new VerificationCode(new Date(), verificationCode));
        } else {
            dataGateway.update(userId, new VerificationCode(new Date(), verificationCode));
        }

        User user = userDataGateway.findById(userId);

        String emailBody = String.format("Your verification code is: %s\nThis code expire in 5 minutes", verificationCode);
        sendEmail(user.getEmail(), "Verify Your Email", emailBody);
    }

    /**
     * Send email.
     *
     * @param to      the email address of receiver
     * @param subject the subject of email
     * @param body    the body of email
     */
    public static void sendEmail(String to, String subject, String body) {
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object. and pass username and password, new object() {} is an anonymous class constructed and instanced
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("davidzylin@gmail.com", "rxkhjumbramsgmhg");

            }

        });

        // Used to debug SMTP issues (Simple Mail Transfer Protocol)
        session.setDebug(true);

        try {
            InternetAddress from = new InternetAddress("davidzylin@gmail.com", "Skip the Line");

            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(from);

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
