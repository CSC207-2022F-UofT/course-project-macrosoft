package Entities;

import java.util.Date;

public class VerificationCode {
    private Date createDate;
    private String code;

    public VerificationCode(Date createDate, String code) {
        this.createDate = createDate;
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
