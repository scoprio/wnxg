package com.ulb.web.dto;

import java.math.BigDecimal;

/**
 * Created by wangpeng on 21/08/2017.
 */
public class ResultWithQFDTO {

    private String code;

    private String message;

    private Integer recordId;

    private BigDecimal money;


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

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
