package entities;

import java.util.Date;

/**
 * This class is the verification code entity.
 */
public class VerificationCode {
    private final Date createDate;
    private String code;

    /**
     * Constructor for VerificationCode
     *
     * @param createDate the creation date
     * @param code       the verification code
     */
    public VerificationCode(Date createDate, String code) {
        this.createDate = createDate;
        this.code = code;
    }

    /**
     * Gets the creation date
     *
     * @return the creation date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Gets the verification code
     *
     * @return the verification code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the verification code
     *
     * @param code the verification code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
