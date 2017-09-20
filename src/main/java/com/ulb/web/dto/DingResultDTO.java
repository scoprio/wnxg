package com.ulb.web.dto;

/**
 * Created by wangpeng on 21/08/2017.
 */
public class DingResultDTO {

    private int errcode;

    private String errmsg;

    private String receiver;

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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
