package com.ulb.web.dto;

/**
 * Created by wangpeng on 21/08/2017.
 */
public class DingResultDTO {

    private int errcode;

    private String errmsg;

    private String invaliduser;

    private String invalidparty;

    private String forbiddenUserId;

    private String messageId;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public String getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(String invalidparty) {
        this.invalidparty = invalidparty;
    }

    public String getForbiddenUserId() {
        return forbiddenUserId;
    }

    public void setForbiddenUserId(String forbiddenUserId) {
        this.forbiddenUserId = forbiddenUserId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
