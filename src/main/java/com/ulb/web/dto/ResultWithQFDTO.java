package com.ulb.web.dto;

/**
 * Created by wangpeng on 21/08/2017.
 */
public class ResultWithQFDTO {

    private String code;

    private String message;

    private String recordId;

    private String money;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
