package database;

import entities.VerificationCode;
import org.bson.types.ObjectId;

public interface VerificationCodeDataGateway {
    public String save(VerificationCode verificationCode);
    public String delete(VerificationCode verificationCode);
    public String create(VerificationCode verificationCode);
    public String deleteByUserId(ObjectId userId);
    public VerificationCode validateAndReadByUser(ObjectId userId);
}
