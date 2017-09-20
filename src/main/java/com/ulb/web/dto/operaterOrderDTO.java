package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class OperaterOrderDTO {

    private String cityCode;

    private Integer operater;

    private String reason;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getOperater() {
        return operater;
    }

    public void setOperater(Integer operater) {
        this.operater = operater;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
